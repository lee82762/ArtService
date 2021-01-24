package com.project.restfulproject.Controller;

import com.project.restfulproject.Domain.Dto.MemebrDto.LoginDto;
import com.project.restfulproject.Domain.Dto.MemebrDto.SigninDto;
import com.project.restfulproject.Domain.Dto.MemebrDto.SignupDto;
import com.project.restfulproject.Domain.Dto.MemebrDto.UpdateDto;
import com.project.restfulproject.Domain.Entity.MemberEntity;
import com.project.restfulproject.Service.MemberService.DeleteService;
import com.project.restfulproject.Service.MemberService.SigninService;
import com.project.restfulproject.Service.MemberService.SingupService;
import com.project.restfulproject.Service.MemberService.UpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/member")
public class MemberController {

    private final SingupService singupService;
    private final DeleteService deleteService;
    private final SigninService signinService;
    private final UpdateService updateService;

    public MemberController(SingupService singupService, DeleteService deleteService, SigninService signinService, UpdateService updateService) {
        this.singupService = singupService;
        this.deleteService = deleteService;
        this.signinService = signinService;
        this.updateService = updateService;
    }

    @RequestMapping("/")
    public String login() {
        return "login1";
    }


    //<a href="signUp">Create an Account</a></p>
    @RequestMapping("/signUp")
    public String signUp() {
        return "signUp1";
    }


 /*   @PostMapping(value = "/signUp/create")
    public ResponseEntity<MemberEntity> signupUser(SignupDto signupDto){
        MemberEntity memberEntity=singupService.creatUser(signupDto);
        return ResponseEntity.ok(memberEntity);
    }*/


    @PostMapping(value = "/signUp/create")
    public String signupUser1(SignupDto signupDto, HttpServletResponse response) throws IOException {
        MemberEntity memberEntity=singupService.creatUser(signupDto);
        response.setContentType("text/html; charset=euc-kr");
        PrintWriter out = response.getWriter();
        out.println("<script>alert('회원가입 성공'); location.href=/member/; </script>");
        out.flush();
        return null;
    }
    @GetMapping("/login/logout")
    public String logoutUser(HttpSession session){
        session.invalidate();
        return "redirect:/member/";
    }



    @GetMapping("/login/usercheck")
    public String checkUser(HttpSession session){
        String id=session.getAttribute("member").toString();
        System.out.println(id);
        return "usercheck";
    }

    @GetMapping("/login/usercheck/update")
    public String updatekUser(HttpSession session){
        return "update";
    }

/*    @PostMapping("/login")
    public String loginUser(SigninDto signinDto) throws Exception {
       LoginDto loginDto=signinService.loginUser(signinDto);
        System.out.println(loginDto.getMessage());
        if(loginDto.getMessage().equals("로그인 성공")){
            return "test";
        }
        else{
            return "redirect:/member/";
        }

    }*/

    @PostMapping("/login")
    public String loginUser(SigninDto signinDto, HttpServletResponse response, HttpServletRequest request) throws Exception {
        LoginDto loginDto=signinService.loginUser(signinDto);

        HttpSession session=request.getSession();
        MemberEntity memberEntity1=signinService.loginUser1(signinDto);
        System.out.println(session);

        if(memberEntity1 == null) {
            session.setAttribute("member", null);
        }
        else {
            session.setAttribute("member", memberEntity1);
        }

       // System.out.println("session="+session.getAttribute("member"));

        MemberEntity user=(MemberEntity)session.getAttribute("member");


        if(loginDto.getMessage().equals("로그인 성공")){
            return  "test";
        }
        else if(loginDto.getMessage().equals("비밀번호 오류")){
            response.setContentType("text/html; charset=euc-kr");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('비밀번호가 틀립니다'); location.href=/member/; </script>");
            out.flush();
            return null;
        }
        else{
            return "redirect:/member/";
        }
    }
  /*  @PostMapping("/login")
    public String loginUser(SigninDto signinDto){
        LoginDto loginDto=signinService.loginUser(signinDto);
        if(loginDto==null){
            System.out.println("Ddddddd");
        }
        return  ResponseEntity.ok(loginDto);
    }*/

    @PostMapping("/login/usercheck/update/update1")
    public  ResponseEntity<UpdateDto> updateUser(UpdateDto updateDto,HttpServletRequest request){
        HttpSession session1 = request.getSession(true);
        MemberEntity memberEntity=(MemberEntity)session1.getAttribute("member");
        String address=memberEntity.getAddress();

        updateService.updateMember(updateDto,address);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/login/usercheck/update/delete")
    public String deleteUser(Long id,HttpServletRequest request){
        HttpSession session=request.getSession(true);
        MemberEntity memberEntity=(MemberEntity)session.getAttribute("member");
        id=memberEntity.getId();
        deleteService.memberDelete(id);
        session.invalidate();
        return "redirect:/member/";
    }
}
