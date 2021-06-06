package com.test.demo.service;
        import com.test.demo.entity.*;
        import com.test.demo.mapper.InformationMapper;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import org.springframework.transaction.annotation.Transactional;
import  java.util.regex.Pattern;
        import java.util.List;
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class InformationService {
    @Autowired
    private InformationMapper informationMapper;
    /**
     * 普通插入
     * 检验
     *
     */
    public InsertResult insert(Information information) {
        InsertResult insertResult = new InsertResult();
        insertResult.setSuccess(false);
        insertResult.setDetail(null);
        String title = information.getInfo_title();
        String content = information.getInfo_content();
        String phone = information.getInfo_phone();
        String price = information.getInfo_price();
        String datestart = information.getInfo_datestart();
        String dateend = information.getInfo_dateend();
        String reg = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])|(18[0-9])|(19[8,9]))\\d{8}$";
        try {
            if (title.length() < 2 || title.length() > 10)
            {
                insertResult.setMsg("标题不符合要求");
            }
            else if(content.length() < 10 || content.length() >300)
            {
                insertResult.setMsg("内容不符合要求");
            }
            else if(!(phone.length() == 0) && !Pattern.matches(reg,phone))
            {
                insertResult.setMsg("手机号码不合法！");
            }
            else {
                informationMapper.insert(information);
                insertResult.setMsg("插入信息成功");
                insertResult.setSuccess(true);
                insertResult.setDetail(information);
            }

        }catch (Exception e) {
            insertResult.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return insertResult;
    }
    /**
     * 按照信息类别搜索
     *
     */
    public List<Information> getbycate(Cate cate) {
        try{
            System.out.println(cate.getCates_name());

        }catch (Exception e) {

            e.printStackTrace();
        }
        return informationMapper.findInformationByPid(cate.getCates_name());
    }
    /**
     * 按照用户名搜索
     *
     */
    public List<Information> getbyusername(User user) {
        return informationMapper.findInformationByUsername(user.getUsername());

    }
    /**
     * 按照输入信息搜索
     *
     */
    public List<Information> getbysearch(Information information) {
        return informationMapper.findInformationBySearch(information.getCates_name(),information.getInfo_title(),information.getInfo_content());

    }
    /**
     * 用户修改信息
     *
     */
    public InsertResult update(Information information){
        InsertResult insertResult = new InsertResult();
        insertResult.setSuccess(false);
        insertResult.setDetail(null);
        String title = information.getInfo_title();
        String content = information.getInfo_content();
        String phone = information.getInfo_phone().trim();
        String price = information.getInfo_price();
        String datestart = information.getInfo_datestart();
        String dateend = information.getInfo_dateend();
        String reg = "^((13[0-9])|(14[5,7,9])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])|(18[0-9])|(19[8,9]))\\d{8}$";
        try {
            if (title.length() < 2 || title.length() > 10)
            {
                insertResult.setMsg("标题不符合要求");
            }
            else if(content.length() < 10 || content.length() >300)
            {
                insertResult.setMsg("内容不符合要求");
            }
            else if(!(phone.length() == 0) && !Pattern.matches(reg,phone))
            {
                insertResult.setMsg("手机号码不合法！");
            }
            else {
                informationMapper.update(information);
                Information info = informationMapper.selectbyinfoid(information.getInfo_id());
                insertResult.setMsg("修改信息成功");
                insertResult.setSuccess(true);
                insertResult.setDetail(info);

            }

        }catch (Exception e) {
            insertResult.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return insertResult;
    }
//    /**
//     * 用户删除信息
//     *
//     */
    public InsertResult delete(Information information){
        InsertResult insertResult = new InsertResult();
        informationMapper.delete(information.getInfo_id());
           try{
        Information info = informationMapper.selectbyinfoid(information.getInfo_id());
        if(info == null){
            insertResult.setMsg("删除成功!!!");
            insertResult.setSuccess(true);
            insertResult.setDetail(null);
        }else{
            insertResult.setMsg("删除失败!!!");
            insertResult.setSuccess(false);
            insertResult.setDetail(info);
        }

    }catch (Exception e) {

        e.printStackTrace();
    }
        return insertResult;
    }


}
