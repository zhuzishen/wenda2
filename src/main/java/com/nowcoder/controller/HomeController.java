package com.nowcoder.controller;

import com.nowcoder.model.Question;
import com.nowcoder.model.ViewObject;
import com.nowcoder.service.QuestionService;
import com.nowcoder.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.ObjectView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nowcoder on 2016/7/15.
 */
@Controller
public class HomeController {

    @Resource
    UserService userService;
    @Resource
    QuestionService questionService;
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
//    @ResponseBody 返回的是一个Json格式的数据给前端
//    倘若我们是要搭建页面的话，那么我们是不需要这个的。
    @RequestMapping(path = {"/","/index"},method = {RequestMethod.GET})
//    httpsession的作用就是存取其中的会话信息。
    public String index(Model model){
        //使用model向前台传数据
       //要想向前端传数据，就要调用数据库拿到数据 一般数据的存储方式都是采用list来存储
        //下面这句代码是拿到问答中的问题的所有的数据
        List<Question> questionList = questionService.getLatestQuestions(0,0,10);
        List<ViewObject> vos = new ArrayList<ViewObject>();
        for(Question question : questionList){
            ViewObject vo = new ViewObject();
            vo.set("question",question);
            vo.set("user",userService.getUser(question.getUserId()));
            vos.add(vo);
        }

        model.addAttribute("vos",vos);
        return "index";
    }

}
