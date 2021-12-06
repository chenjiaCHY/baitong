package com.ntschy.baitong.service.impl;

import com.ntschy.baitong.dao.AddressDao;
import com.ntschy.baitong.entity.DO.AddressRecord;
import com.ntschy.baitong.entity.base.Result;
import com.ntschy.baitong.entity.dto.RadarRequest;
import com.ntschy.baitong.service.AddressService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.params.MapSolrParams;
import org.locationtech.spatial4j.context.SpatialContext;
import org.locationtech.spatial4j.distance.DistanceUtils;
import org.locationtech.spatial4j.shape.Rectangle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AddressServiceImpl implements AddressService {

    @Resource
    private AddressDao addressDao;

    @Autowired
    private SolrClient solrClient;

    /**
     * 搜索地址
     * @param key
     * @return
     * @throws IOException
     * @throws SolrServerException
     */
    @Override
    public List<SolrDocument> search(String key) throws IOException, SolrServerException {

        Map<String, String> queryParamMap = new HashMap<>();
        queryParamMap.put("q", key);
        queryParamMap.put("q.op", "or");
        queryParamMap.put("df", "DZYS_WZDZXX");
        queryParamMap.put("fl", "*,score");

        MapSolrParams mapSolrParams = new MapSolrParams(queryParamMap);
        QueryResponse response = solrClient.query(mapSolrParams);

        return response.getResults();

    }

    /**
     * 找到一定范围内的地址
     * @param radarRequest
     * @return
     * @throws RuntimeException
     */
    @Override
    public Result radar(RadarRequest radarRequest) throws RuntimeException {

        SpatialContext geo = SpatialContext.GEO;

        Rectangle rectangle = geo.getDistCalc().calcBoxByDistFromPt(geo.getShapeFactory().pointXY(radarRequest.getX(), radarRequest.getY()), radarRequest.getDistance() / 1000 * DistanceUtils.KM_TO_DEG, geo, null);

        List<AddressRecord> addressList = addressDao.radar(rectangle.getMinX(), rectangle.getMaxX(), rectangle.getMinY(), rectangle.getMaxY());

        return new Result<>(addressList);
    }

}
