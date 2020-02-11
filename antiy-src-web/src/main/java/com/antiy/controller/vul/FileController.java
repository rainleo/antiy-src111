package com.antiy.controller.vul;

import com.antiy.base.RespBasicCode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import com.antiy.base.ActionResponse;
import io.swagger.annotations.Api;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
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
    private String filePath;

    @RequestMapping(value = "upload", method = RequestMethod.POST)
    @ResponseBody
    public ActionResponse upload(@RequestParam("file") MultipartFile file) {
        // 获取原始名字
        String fileName = file.getOriginalFilename();
        // 获取后缀名
        // String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件重命名，防止重复
        fileName = filePath + "//" + UUID.randomUUID() + "//" + fileName;
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

   /* @RequestMapping("download")
    public void download(HttpServletResponse response) throws Exception {
        // 文件地址，真实环境是存放在数据库中的
        File file = new File("D:\\upload\\a.txt");
        // 穿件输入对象
        FileInputStream fis = new FileInputStream(file);
        // 设置相关格式
        response.setContentType("application/force-download");
        // 设置下载后的文件名以及header
        response.addHeader("Content-disposition", "attachment;fileName=" + "a.txt");
        // 创建输出对象
        OutputStream os = response.getOutputStream();
        // 常规操作
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = fis.read(buf)) != -1) {
            os.write(buf, 0, len);
        }
        fis.close();
    }*/
}
