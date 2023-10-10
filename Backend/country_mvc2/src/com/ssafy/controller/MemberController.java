package com.ssafy.controller;

public class MemberController {

	
	
	
	private void logout() {
		
	}
	private void regist(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
        System.out.println("등록 요청 수신");
        
        HttpSession session = request.getSession();
        if(session.getAttribute("memberInfo")==null) {
            System.out.println("권한 없는 요청");
            
            request.getRequestDispatcher("/error/error401.jsp").forward(request, response);
            return;
        }
        
        
        //1. 등록할 국가 정보를 파라미터로부터 추출 및 Country로 가공
        String code = request.getParameter("code");
        String name = request.getParameter("name");
        String continent = request.getParameter("continent");
        double gnp = Double.parseDouble(request.getParameter("gnp"));
        Country country = new Country(code, name, continent, gnp);
        System.out.println("등록할 국가 정보: "+country);
        
        //2. Service의 등록 메소드 호출해서 요청처리 맡김
        int cnt = countryService.insertCountry(country);
        
        //3. 등록 성공 시, 브라우저에게 새로 요청 주소값 반환
        response.sendRedirect(request.getContextPath()+"/country?action=view&code="+code);
    }
    private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        System.out.println("로그인 요청 수신");
        //1. 아이디, 비밀번호 값 추출 
        String memberId = request.getParameter("memberId");
        String password = request.getParameter("password");
        Member member = new Member();
        member.setMemberId(memberId);
        member.setPassword(password);
        
        
        //2. DB에 해당 멤버 조회
        Member memberInfo = memberService.login(member);
        
        //로그인 성공
        if(memberInfo!=null) {
            System.out.println("로그인한 유저의 정보:"+memberInfo);
            //3. 해당 멤버가 존재한다면 세션에 유저 정보 저장
            HttpSession session = request.getSession();
            session.setAttribute("memberInfo", memberInfo);
            
            
            
            // ============아이디 저장 쿠키 관련=================
            String isRemember = request.getParameter("isRemember");
            System.out.println("isRemember 파라미터 : "+isRemember);
            
            //아이디 저장 해야됨
            if(isRemember!=null) {
                Cookie cookie = new Cookie("rememberId", memberId);
                cookie.setMaxAge(60*60);    //1시간 
                response.addCookie(cookie);
            }
            //아이디 저장 X
            else {
                //기존 쿠키를 유효기간 0인 쿠키로 대체(삭제와 비슷한 효과)
                Cookie cookie = new Cookie("rememberId", memberId);
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
            
            
            //============================================
            
            //4. 클라이언트가 새로요청할 주소값 넘김
            response.sendRedirect(request.getContextPath());
        }
        //로그인 실패
        else {
            System.out.println("로그인 실패");
            response.sendRedirect(request.getContextPath()+"/member?action=mvLogin");
        }
    }
}
