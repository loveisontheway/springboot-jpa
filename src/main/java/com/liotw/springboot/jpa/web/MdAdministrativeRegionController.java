package com.liotw.springboot.jpa.web;

import com.google.common.collect.Lists;
import com.liotw.springboot.jpa.constants.Constant;
import com.liotw.springboot.jpa.core.PageInfo;
import com.liotw.springboot.jpa.core.Result;
import com.liotw.springboot.jpa.core.TreeNode;
import com.liotw.springboot.jpa.domain.MdAdministrativeRegion;
import com.liotw.springboot.jpa.repository.MdAdministrativeRegionRepository;
import com.liotw.springboot.jpa.service.MdAdministrativeRegionService;
import com.liotw.springboot.jpa.utils.ResponseMsgUtil;
import com.liotw.springboot.jpa.utils.TreeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 行政区划-Controller类
 * @author jiangjialiang on 2017/12/20
 * @version 3.0.0
 */
@Api(description = "行政区划")
@RestController
@RequestMapping("/mdAdministrativeRegion")
public class MdAdministrativeRegionController {

    @Autowired
    private MdAdministrativeRegionService mdAdministrativeRegionService;

    @Autowired
    private MdAdministrativeRegionRepository mdAdministrativeRegionRepository;

    private static final int PAGE_SIZE = 10;

    private static final Logger LOGGER = LoggerFactory.getLogger(MdAdministrativeRegionController.class);

    /**
     * 分页
     * @param pageNumber 页码
     * @param pageSize 页数
     * @return Result<PageInfo> 分页信息
     */
    @GetMapping("/page")
    public Result<PageInfo> page(@PathParam(value = "pageNumber") String pageNumber,
                                 @PathParam(value = "pageSize") String pageSize) {

        LOGGER.info("accessing page pageNumber is {}.", pageNumber);
        int pageNumberInt = 0;
        if (!StringUtils.isEmpty(pageNumber) && StringUtils.isNumeric(pageNumber)) {
            pageNumberInt = Integer.parseInt(pageNumber);
        }
        int pageSizeInt = 0;
        if (!StringUtils.isEmpty(pageSize)) {
            pageSizeInt = Integer.parseInt(pageSize);
        }

        MdAdministrativeRegion operlog = new MdAdministrativeRegion();

        Example<MdAdministrativeRegion> example = Example.of(operlog);

        List<Sort.Order> orders = new ArrayList<Sort.Order>();

        orders.add(new Sort.Order(Sort.Direction.DESC, "createTime"));

        // pageNumber 从0 开始
        Pageable pageable = new PageRequest(pageNumberInt, pageSizeInt, new Sort(orders));
        //
        Page<MdAdministrativeRegion> pageObj = mdAdministrativeRegionRepository.findAll(example, pageable);

        Long totalNum = mdAdministrativeRegionRepository.count();

        List<MdAdministrativeRegion> list = pageObj.getContent();

        if (list == null || list.size() == 0) {
            LOGGER.warn("search result no record!!");
            return ResponseMsgUtil.failure();
        } else {
            PageInfo pageInfo = new PageInfo();
            pageInfo.setCurrentPageNumber(pageNumberInt);
            pageInfo.setPageSize(PAGE_SIZE);
            pageInfo.setRecords(list);
            pageInfo.setTotalPage(pageObj.getTotalPages());
            pageInfo.setTotalNum(totalNum);
            LOGGER.info("query listinfo Success.");
            return ResponseMsgUtil.success(pageInfo);
        }
    }

    @ApiOperation(value = "根据行政区划id获取列表", notes = "暂不支持行政区域code查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "行政区域id(主键)", required = false, dataType = "Long")
    })
    @GetMapping("/list")
    public Result<Object> list(Integer id){
        Result<Object> result = new Result<Object>();
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        List<MdAdministrativeRegion> mdAdministrativeRegionList = mdAdministrativeRegionService.findMdAdministrativeRegion(params);
        if (mdAdministrativeRegionList != null) {
            result.setResCode(Constant.RESULT_CODE_SUCCESS);
            result.setData(mdAdministrativeRegionList.get(0));
            result.setResMsg("MdAdministrativeRegion Object Success");
            LOGGER.info("--- MdAdministrativeRegion method list return true ---");
        }
        return result;
    }

    @DeleteMapping("/delete")
    public Result<Object> delete(Long id) {
        Result<Object> result = new Result<Object>();
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        mdAdministrativeRegionService.delete(params);
        result.setResCode(Constant.RESULT_CODE_SUCCESS);
        result.setData(id);
        result.setResMsg("MdAdministrativeRegion Object Delete Success");
        LOGGER.info("--- MdAdministrativeRegion method delete success ---");
        return result;
    }

    @ApiOperation(value = "根据行政区划id获取区域树", notes = "按地区获取树")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "行政区划id", required = false, dataType = "Long")
    })
    @GetMapping("/tree")
    public Result<List<TreeNode>> tree(@RequestParam(required = false) String id) {

        try {
            List<String> idList = Lists.newArrayList();
            idList.add(id);
            List<TreeNode> listNode = mdAdministrativeRegionService.tree(idList);
            List<TreeNode> nodes = TreeUtil.convert(listNode, Constant.ROOT_MENU_PID);
            return ResponseMsgUtil.builderResponse(Constant.RESULT_CODE_SUCCESS, "获取区域树成功", nodes);
        } catch (Exception e) {
            LOGGER.error("queryAuthorityMenuTree Exception:", e);
            return ResponseMsgUtil.builderResponse(Constant.RESULT_CODE_FAILURE, "获取区域树失败:服务器异常", null);
        }

    }

}
