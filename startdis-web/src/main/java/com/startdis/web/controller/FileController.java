package com.startdis.web.controller;


import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.kits.auth.AuthInfoUtils;
import com.startdis.comm.minio.domian.FileInfoVO;
import com.startdis.comm.minio.service.MinIOService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author Startdis
 * @email startdis@dianjiukeji.cn
 * @desc 文件操作（MinIO）控制层
 */
@RefreshScope
@RestController
@Api(tags = "文件操作接口")
@RequestMapping(value = "/file")
public class FileController {
    
    @Resource
    MinIOService minIOService;
    
    @Value("${minio.bucketName}")
    private String bucketName;
    
    @ApiOperation("下载一个文件")
    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public void downloadFile(@RequestParam String objectName, HttpServletResponse response) throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        InputStream stream = minIOService.download(bucketName, groupTenantId + "/" + companyTenantId + "/" + objectName);
        response.setHeader("Content-Disposition",
                "attachment;filename=" + URLEncoder.encode(objectName.substring(objectName.lastIndexOf("/") + 1), "UTF-8"));
        response.setContentType("application/octet-stream");
        response.setCharacterEncoding("UTF-8");
        IOUtils.copy(stream, response.getOutputStream());
    }
    
    @ApiOperation(value = "上传一个文件")
    @PostMapping("/upload")
    public ResultBean upload(@RequestParam(name = "multipartFile") MultipartFile multipartFile) throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        minIOService.uploadFile(bucketName, groupTenantId + "/" + companyTenantId + "/" + multipartFile.getOriginalFilename(),
                multipartFile.getInputStream());
        return ResultBean.success();
    }
    
    /*@ApiOperation("列出所有的桶")
    @RequestMapping(value = "/list/buckets", method = RequestMethod.GET)
    public ResultBean<List<BucketVO>> listBuckets() throws Exception {
        List<Bucket> buckets = minIOService.listBuckets();
        //List list = BeanCopyKits.copyListProperties(buckets, BucketVO.class);
        List<BucketVO> list = new ArrayList<>();
        for (int i = 0; i < buckets.size(); i++) {
            list.add(BucketVO.builder().bucketName(buckets.get(i).name()).build());
        }
        return ResultBean.success(list);
    }*/
    
    @ApiOperation("递归列出桶中指定目录的所有文件")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    //public ResultBean listFiles(@RequestParam String bucket) throws Exception {
    public ResultBean listFiles() throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        //minIOService.isFolderExist(bucketName, groupTenantId + "/" + companyTenantId);
        //List<FileInfoVO> fileinfos = minIOService.listObjects(bucket);
        //List<FileInfoVO> fileinfos = minIOService.listObjects(bucket, groupTenantId + "/" + companyTenantId, true);
        List<FileInfoVO> fileinfos = minIOService.listObjects(bucketName, groupTenantId + "/" + companyTenantId, true);
        return ResultBean.success(fileinfos);
    }
    
    
    @ApiOperation("删除一个文件")
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public ResultBean deleteFile(@RequestParam String objectName) throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        minIOService.deleteObject(bucketName, groupTenantId + "/" + companyTenantId + "/" + objectName);
        return ResultBean.success();
    }
    
    //@ApiOperation("删除一个桶")
    //@RequestMapping(value = "/delete/bucket", method = RequestMethod.GET)
    //public ResultBean deleteBucket(@RequestParam String bucket) throws Exception {
    //    minIOService.deleteBucket(bucket);
    //    return ResultBean.success();
    //}
    
    
    @ApiOperation("复制一个文件")
    @GetMapping("/copy")
    //public ResultBean copyObject(@RequestParam String sourceBucket, @RequestParam String sourceObject, @RequestParam String targetBucket,@RequestParam String targetObject) throws Exception {
    public ResultBean copyObject(@RequestParam String sourceObject, @RequestParam String targetObject) throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        minIOService.copyObject(bucketName, groupTenantId + "/" + companyTenantId + "/" + targetObject, bucketName,
                groupTenantId + "/" + companyTenantId + "/" + sourceObject);
        return ResultBean.success();
    }
    
    @GetMapping("/get")
    @ApiOperation("获取文件详细信息")
    public ResultBean getObjectInfo(@RequestParam String objectName) throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        return ResultBean.success(minIOService.getObjectInfo(bucketName, groupTenantId + "/" + companyTenantId + "/" + objectName));
    }
    
    @GetMapping("/share")
    @ApiOperation("分享下载链接")
    public ResultBean getPresignedObjectUrl(@RequestParam String objectName, @RequestParam Integer expires) throws Exception {
        String groupTenantId = AuthInfoUtils.getGroupTenantId();
        String companyTenantId = AuthInfoUtils.getCompanyTenantId();
        return ResultBean.success("下载成功！",
                minIOService.getPresignedObjectUrl(bucketName, groupTenantId + "/" + companyTenantId + "/" + objectName, expires));
    }
    
    
    /*@GetMapping("/list/all/file")
    @ApiOperation("获取minio中所有的文件")
    public ResultBean listAllFile() throws Exception {
        
        return ResultBean.success(minIOService.listAllFile());
    }*/
    
    
}
