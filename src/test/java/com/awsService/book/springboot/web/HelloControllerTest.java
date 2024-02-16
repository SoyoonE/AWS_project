package com.awsService.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
// 테스트 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킨다.
// 여기서는 SpringRunner라는 스프링 실행자를 사용.
// 즉, 스프링부트 테스트와 JUnit 사이에 연결자 역할.
@WebMvcTest(controllers = HelloController.class)
// Web에 집중하는 어노테이션. 선언할 경우 @Controller. @ControllerAdvice 등 사용 가능
// 단 @Sevice, @Component 등은 사용 불가능
// 여기서는 컨트롤러만 사용하기 때문에 선언해둠!
public class HelloControllerTest {

    @Autowired
    // 스프링이 관리하는 빈(bean) 주입
    private MockMvc mvc;
    // 웹 API 테스트할 때 사용
    // 스프링 MVC 테스트의 시작점
    // 이 클래스를 통해 HTTP, GET, POST 등 API 테스트 가능함.

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))           // 주소(/hello)로 HTTP GET 요청함. (체이닝 되어 아래 다른 검증을 이어서 할 수 있음.)
                .andExpect(status().isOk())             // HTTP Status 검증. (200, 404 ...)
                .andExpect(content().string(hello));    // mvc.perform 결과 검증. hello가 리턴되면 테스트가 잘 되는것!
    }
}

// 여기서 기억할 것!
// 1. 톰캣 없이도 HTTP 테스트를 할 수 있다.
// 2. 테스트코드 작성하는 방법 기억해두기