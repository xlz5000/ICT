/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.102
 * Generated at: 2025-04-21 09:10:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.midproject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_005fdept_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<title>중간플젝 - 학과소개</title>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".thumbs_wrapper{\r\n");
      out.write("	display: flex;\r\n");
      out.write("	flex-wrap: wrap;\r\n");
      out.write("	justify-content: space-between;	\r\n");
      out.write("	margin: 60px 0 0 20%; /* 상 우 하 좌 */ \r\n");
      out.write("	padding: 20px 0 0 5%;\r\n");
      out.write("	box-sizing: border-box;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".thumbs_item{\r\n");
      out.write("	width: 20%;  \r\n");
      out.write("	margin: 0 0 15px 0 ;\r\n");
      out.write("	padding: 0 10px;\r\n");
      out.write("	background-color: #082567;\r\n");
      out.write("	border-radius: 30px;\r\n");
      out.write("	\r\n");
      out.write("	\r\n");
      out.write("	  min-height: 600px;\r\n");
      out.write("	  height: auto;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".thumbs_info{\r\n");
      out.write("	display: flex;\r\n");
      out.write("	align-items: center;\r\n");
      out.write("	color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".thumbs_text{\r\n");
      out.write("	/* margin-left: 10px; */\r\n");
      out.write("	padding-left: 20px;\r\n");
      out.write("	margin-bottom: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".thumbs_text > h1{\r\n");
      out.write("  font-size: 45px;\r\n");
      out.write("  margin-bottom: 10px;	\r\n");
      out.write("  text-align: center;\r\n");
      out.write(" \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".thumbs_text > p{\r\n");
      out.write("  font-size: 30px;\r\n");
      out.write("  margin-bottom: 10px;	\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(".nav{\r\n");
      out.write("	position: fixed;\r\n");
      out.write("	top: 0px;\r\n");
      out.write("	left:0px;\r\n");
      out.write("	z-index: 4;\r\n");
      out.write("	width: 20%;\r\n");
      out.write("	padding-top: 80px;\r\n");
      out.write("	box-sizing: border-box;\r\n");
      out.write("	margin-left: 5%;\r\n");
      out.write("	padding-left: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("i{\r\n");
      out.write("display: block;\r\n");
      out.write("font-size: 35px;\r\n");
      out.write("text-align: center; /*부모가 블록이여야 적용 가능*/\r\n");
      out.write(" color: silver;\r\n");
      out.write("\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h2{\r\n");
      out.write("color: white; font-size: 70px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<body style=\"background-image:url('https://cdn.pixabay.com/photo/2020/01/09/03/43/mansion-4751778_640.jpg');background-repeat: no-repeat;background-size: cover;\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("	<nav class=\"nav\">\r\n");
      out.write("	\r\n");
      out.write("	<h2>Department\r\n");
      out.write("	<br>Overview</h2>\r\n");
      out.write("	</nav>\r\n");
      out.write("<div>\r\n");
      out.write("	<section class=\"thumbs\">\r\n");
      out.write("		<div class=\"thumbs_wrapper\">\r\n");
      out.write("			<div class=\"thumbs_item\">\r\n");
      out.write("				\r\n");
      out.write("				<div class=\"thumbs_info\">\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"thumbs_text\">\r\n");
      out.write("						<h1>영어영문학과</h1>\r\n");
      out.write("						<p><b><i>'세계를 읽고, <br> 세상과 소통하는 힘 <br> – 영문학의 길에서 시작됩니다.'</i></b></p>\r\n");
      out.write("						<p>영문학과는 영어권 문학과 언어를 통해 세계 문화를 깊이 있게 이해하고, \r\n");
      out.write("						글로벌 소통 역량을 키우는 인재를 양성합니다. 고전부터 현대 대중문화까지 폭넓게 탐구하며, \r\n");
      out.write("						원어민 교수진의 수업, 영어 연극제, 해외 교환 프로그램 등 실용적인 교육 환경을 제공합니다.</p>\r\n");
      out.write("						\r\n");
      out.write("						<p> 외국계 기업, 번역/출판, 교육, 콘텐츠 분야 진출\r\n");
      out.write("						국내외 대학원 진학률 우수\r\n");
      out.write("						글로벌 역량 강화 프로그램 운영</p>\r\n");
      out.write("						\r\n");
      out.write("						\r\n");
      out.write("						<br>\r\n");
      out.write("						\r\n");
      out.write("						\r\n");
      out.write("						\r\n");
      out.write("						\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"thumbs_item\">\r\n");
      out.write("			\r\n");
      out.write("				<div class=\"thumbs_info\">\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"thumbs_text\">\r\n");
      out.write("						<h1>컴퓨터공학과</h1>\r\n");
      out.write("						<p><b><i>'미래를 설계하고,<br> 기술로 세상을 바꾸다 <br>– 컴퓨터공학의 힘.'</i></b></p>\r\n");
      out.write("						<p>컴퓨터공학과는 소프트웨어, 인공지능, 데이터 등 첨단 기술 중심 교육을 통해 실무 역량을 갖춘 IT 인재를 양성합니다. \r\n");
      out.write("						캡스톤디자인, 해커톤, 산학협력 프로젝트 등 현장 중심의 학습 환경을 제공합니다.</p>\r\n");
      out.write("						<p>대기업, 스타트업, 공공기관, 연구소 진출\r\n");
      out.write("\r\n");
      out.write("						최신 실습실, 산업체 연계 교육 운영\r\n");
      out.write("						\r\n");
      out.write("						국내외 인턴십 및 취업 연계 강화</p>\r\n");
      out.write("						\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"thumbs_item\">\r\n");
      out.write("			\r\n");
      out.write("				<div class=\"thumbs_info\">\r\n");
      out.write("				\r\n");
      out.write("					<div class=\"thumbs_text\">\r\n");
      out.write("						<h1>경영학과</h1>\r\n");
      out.write("						<p><b><i>'미래를 설계하고,<br> 기술로 세상을 바꾸다 <br>– 컴퓨터공학의 힘.'</i></b></p>\r\n");
      out.write("						<p>경영학과는 기업 경영의 핵심 이론과 실무를 균형 있게 교육하며, 실제 기업 프로젝트 및 창업 체험을 통해 실전 역량을 기릅니다. \r\n");
      out.write("						글로벌 비즈니스 환경에 대응할 수 있는 유연하고 창의적인 인재를 양성합니다.</p>\r\n");
      out.write("						<p>\r\n");
      out.write("						대기업, 금융권, 창업 등 다양한 진로\r\n");
      out.write("						\r\n");
      out.write("						모의 창업, 경영 시뮬레이션 등 실습 프로그램\r\n");
      out.write("						\r\n");
      out.write("						글로벌 교환 프로그램 및 영어 강의 다수 운영</p>\r\n");
      out.write("						\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"thumbs_item\">\r\n");
      out.write("				\r\n");
      out.write("				<div class=\"thumbs_info\">\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"thumbs_text\">\r\n");
      out.write("						<h1>심리학과</h1>\r\n");
      out.write("						<p><b><i>'미래를 설계하고,<br> 기술로 세상을 바꾸다 <br>– 컴퓨터공학의 힘.'</i></b></p>\r\n");
      out.write("						<p>심리학과는 인간의 사고와 행동을 과학적으로 탐구하고, 사회 문제에 적용할 수 있는 전문성을 키우는 학문입니다. \r\n");
      out.write("						실험, 통계, 상담 실습 등 다양한 교육 활동을 통해 실무와 연구 능력을 동시에 배양합니다.</p>\r\n");
      out.write("						<p>상담사, 심리치료사, 공공기관, 기업 인사 등 진출\r\n");
      out.write("							\r\n");
      out.write("							자격증 과정, 워크숍, 기관 연계 실습 운영\r\n");
      out.write("							\r\n");
      out.write("							대학원 진학 및 연구 활동 활발</p>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"thumbs_item\">\r\n");
      out.write("				\r\n");
      out.write("				<div class=\"thumbs_info\">\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"thumbs_text\">\r\n");
      out.write("						<h1>간호학과</h1>\r\n");
      out.write("						<p><b><i>'미래를 설계하고,<br> 기술로 세상을 바꾸다 <br>– 컴퓨터공학의 힘.'</i></b></p>\r\n");
      out.write("						<p>간호학과는 보건의료 분야의 핵심 인재를 양성하기 위해 이론과 실습을 체계적으로 교육합니다. \r\n");
      out.write("						최신 의료 장비를 갖춘 실습실과 대형 병원과의 협약을 통해 실제 임상 경험을 쌓을 수 있는 환경을 제공합니다.</p>\r\n");
      out.write("						<p>대학병원, 보건소, 산업체 간호사 등 진출\r\n");
      out.write("\r\n");
      out.write("							간호사 국가고시 준비 체계 운영\r\n");
      out.write("							\r\n");
      out.write("							응급 간호, 시뮬레이션 센터 등 실습 특화 환경</p>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"thumbs_item\">\r\n");
      out.write("			\r\n");
      out.write("				<div class=\"thumbs_info\">\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"thumbs_text\">\r\n");
      out.write("						<h1>연극영화과</h1>\r\n");
      out.write("						<p><b><i>'미래를 설계하고,<br> 기술로 세상을 바꾸다 <br>– 컴퓨터공학의 힘.'</i></b></p>\r\n");
      out.write("						<p>연극영화과는 연기, 연출, 시나리오, 영상제작 등 공연예술과 영상미디어 분야 전반을 아우르는 종합 예술학과입니다.\r\n");
      out.write("						 이론과 실습을 바탕으로 무대 예술과 영상 콘텐츠 제작 역량을 함께 기르며, 각종 워크숍, 작품 발표회,\r\n");
      out.write("						  단편영화 제작 등 실기 중심의 교육이 강점입니다. 또한, 업계 전문가 특강과 국내외 영화제 참관 기회 등을 통해 현장 감각을 익힐 수 있습니다.</p>\r\n");
      out.write("						<p>\r\n");
      out.write("						배우, 연출가, 작가, 영화·드라마 제작자 등 진출\r\n");
      out.write("\r\n");
      out.write("						예술기획사, 방송사, 영상 콘텐츠 제작사 취업\r\n");
      out.write("						\r\n");
      out.write("						영화제 수상 경력 다수, 문화예술특성화 지원 우수\r\n");
      out.write("						</p>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"thumbs_item\">\r\n");
      out.write("			\r\n");
      out.write("				<div class=\"thumbs_info\">\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"thumbs_text\">\r\n");
      out.write("						<h1>경찰행정학과</h1>\r\n");
      out.write("						<p><b><i>'미래를 설계하고,<br> 기술로 세상을 바꾸다 <br>– 컴퓨터공학의 힘.'</i></b></p>\r\n");
      out.write("						<p>경찰행정학과는 법과 질서, 공공안전 분야의 전문가를 양성하는 학과로, 범죄학, 형사법, 수사학, 행정법 등 실무 중심의 커리큘럼을 제공합니다. \r\n");
      out.write("						실습 중심 수업과 함께 경찰시험 대비 특강, 체력훈련, 상황 대응 훈련 등 실전 교육이 잘 갖춰져 있습니다. \r\n");
      out.write("						경찰공무원은 물론 다양한 공공기관 진출을 준비할 수 있습니다.</p>\r\n");
      out.write("						<p>경찰·검찰·교정기관 등 공공안전 분야 진출\r\n");
      out.write("\r\n");
      out.write("						경찰 간부후보생 및 경채시험 대비 과정 운영\r\n");
      out.write("						\r\n");
      out.write("						모의 수사실, 법률 클리닉 등 실습 환경 우수</p>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"thumbs_item\">\r\n");
      out.write("			\r\n");
      out.write("				<div class=\"thumbs_info\">\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"thumbs_text\">\r\n");
      out.write("						<h1>바이오헬스학과</h1>\r\n");
      out.write("						<p><b><i>'미래를 설계하고,<br> 기술로 세상을 바꾸다 <br>– 컴퓨터공학의 힘.'</i></b></p>\r\n");
      out.write("						<p>바이오헬스학과는 생명과학과 헬스케어 기술을 융합해 미래 보건산업을 선도할 전문 인재를 양성합니다. \r\n");
      out.write("						분자생물학, 유전자 분석, 바이오의약품 개발, 바이오센서 등 첨단 분야를 배우며, 실험실 기반 교육과 산업체 연계 프로젝트가 강화되어 있습니다.\r\n");
      out.write("						 헬스 빅데이터 및 디지털 치료기기 연구도 병행합니다.</p>\r\n");
      out.write("						<p>제약회사, 바이오기업, 국가연구기관, 병원 연구실 진출\r\n");
      out.write("\r\n");
      out.write("							최신 실험 장비와 융합 교육 기반\r\n");
      out.write("							\r\n");
      out.write("							바이오스타트업 창업 지원, 특허 출원 경험 가능</p>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("			<div class=\"thumbs_item\">\r\n");
      out.write("				\r\n");
      out.write("				<div class=\"thumbs_info\">\r\n");
      out.write("					\r\n");
      out.write("					<div class=\"thumbs_text\">\r\n");
      out.write("						<h1> 유아교육과</h1>\r\n");
      out.write("						<p><b><i>'미래를 설계하고,<br> 기술로 세상을 바꾸다 <br>– 컴퓨터공학의 힘.'</i></b></p>\r\n");
      out.write("						<p>유아교육과는 0~6세 아동의 발달과 교육을 전문적으로 배우는 학과로, 유아 발달, 놀이이론, 교수법, 보육행정 등을 폭넓게 교육합니다. \r\n");
      out.write("						유아교육기관과의 연계 실습, 수업 시연, 교재 교구 제작 등의 실습 활동이 활발하며, 유치원 정교사 자격증 취득을 위한 체계적 지원 시스템을 갖추고 있습니다.</p>\r\n");
      out.write("						<p>유치원 교사, 어린이집 교사, 유아교육전문가로 진출\r\n");
      out.write("\r\n");
      out.write("							유아교육 현장 실습 및 교육연구 기회 풍부\r\n");
      out.write("							\r\n");
      out.write("							교원 임용시험 대비 프로그램 운영</p>\r\n");
      out.write("					</div>\r\n");
      out.write("				</div>\r\n");
      out.write("			</div>\r\n");
      out.write("\r\n");
      out.write("			</div>\r\n");
      out.write("		</section>\r\n");
      out.write("	</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
