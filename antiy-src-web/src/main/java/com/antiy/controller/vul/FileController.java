package com.antiy.controller.vul;

import com.antiy.base.RespBasicCode;
import com.antiy.entity.vul.FileInfo;
import com.antiy.request.BaseRequest;
import com.antiy.service.vul.IVulExamineInfoService;
import com.antiy.service.vul.IVulInfoService;
import com.antiy.util.BusinessExceptionUtils;
import com.antiy.util.StringLengthUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.antiy.base.ActionResponse;
import io.swagger.annotations.Api;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * @author lvliang
 * @since 2020-02-06
 */
@Api(value = "VulInfo", description = "文件模块")
@RestController
@RequestMapping("/api/v1/file")
public class FileController {

    @Value("${file_url}")
    private String                 filePath;
    @Resource
    private IVulInfoService        vulInfoService;
    @Resource
    private IVulExamineInfoService vulExamineInfoService;

    private static List<String>    fileMatch = Arrays.asList("rar", "zip", "pdf", "doc", "docx", "txt", "7z", "jpg",
        "png", "xlsx", "xls");

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public ActionResponse upload(@RequestParam("file") MultipartFile file) throws UnsupportedEncodingException {
        // 获取原始名字
        String[] fs = file.getOriginalFilename().split("\\\\");
        String fileName = fs[fs.length - 1];
        if (!fileMatch.contains(fileName.substring(fileName.lastIndexOf(".") + 1))) {
            BusinessExceptionUtils.isTrue(false, "不支持该文件格式");
        }
        int length = StringLengthUtils.getWordCountCode(fileName, "UTF-8");
        if (length > 255) {
            BusinessExceptionUtils.isTrue(false, "文件名长度不能查过255");
        }
        // 获取后缀名
        // String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件重命名，防止重复
        fileName = filePath + "/" + UUID.randomUUID() + "/" + fileName;
        // 文件对象
        File dest = new File(fileName);
        // 判断路径是否存在，如果不存在则创建
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            // 保存到服务器中
            file.transferTo(dest);
            return ActionResponse.success(fileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ActionResponse.fail(RespBasicCode.BUSINESS_EXCEPTION, "上传失败");
    }

    @RequestMapping(value = "download", method = RequestMethod.GET)
    public void download(BaseRequest request, HttpServletResponse response) throws Exception {
        long start = System.currentTimeMillis();
        if (Objects.isNull(request.getId()) || Objects.isNull(request.getType())) {
            BusinessExceptionUtils.isTrue(false, "参数不完整");
        }
        FileInfo fileInfo = null;
        if (request.getType() == 1) {
            fileInfo = vulInfoService.queryFilePath(request);
        } else if (request.getType() == 2) {
            fileInfo = vulExamineInfoService.queryFilePath(request);
        }
        if (Objects.isNull(fileInfo) || StringUtils.isBlank(fileInfo.getFileName())
            || StringUtils.isBlank(fileInfo.getFilePath())) {
            BusinessExceptionUtils.isTrue(false, "文件不存在或已被删除,请联系管理员");
        }
        // 文件地址，真实环境是存放在数据库中的
        File file = new File(fileInfo.getFilePath());
        String fileName = fileInfo.getFileName();
        // 穿件输入对象
        FileInputStream fis = new FileInputStream(file);
        // 设置相关格式
        response.setContentType("application/force-download");
        // 设置下载后的文件名以及header
        // response.addHeader("Content-disposition", "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));
        response.setHeader("Content-Disposition",
            "attachment;filename*=utf-8'zh_cn'" + URLEncoder.encode(fileName, "UTF-8"));

        // 创建输出对象
        OutputStream os = response.getOutputStream();
        // 常规操作
        byte[] buf = new byte[1024 * 1024];
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            os.write(buf, 0, len);
        }

        fis.close();
        System.out.println("下载耗时：" + (System.currentTimeMillis() - start));
    }
}
