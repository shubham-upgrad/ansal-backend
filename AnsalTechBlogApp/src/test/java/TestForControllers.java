//import ansaltechblogapp.controllers.HomeController;
//import ansaltechblogapp.controllers.UserController;
//import ansaltechblogapp.models.Post;
//import ansaltechblogapp.models.User;
//import ansaltechblogapp.services.PostService;
//import ansaltechblogapp.services.UserService;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.mock.web.MockHttpServletResponse;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//import static org.mockito.ArgumentMatchers.any;
//
//@ExtendWith(SpringExtension.class)
//@AutoConfigureMockMvc
//@SpringBootTest(classes = {HomeController.class, UserController.class})
//public class TestForControllers {
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    PostService postService;
//    @MockBean
//    UserService userService;
//    private ArrayList<Post> mockPosts=new ArrayList<>();
//    @Test
//    public void testTheHomeController() throws Exception{
//        //1. We define stubs and mockData
//
//        mockPosts.add(new Post("Title","First Body",new Date()));
//        // creating a stub(or mocking the getAllposts() method)
//        // The line Mockito.when(postService.getAllPosts()).thenReturn(mockPosts);:
//        // is saying that while testing home controller..
//        // when postService.getAllPosts() is called....then
//        // return mockPosts(a mock list of posts made by us)
//        Mockito.when(postService.getAllPosts()).thenReturn(mockPosts);
//
//        //2. Define your request
//        RequestBuilder requestBuilder= MockMvcRequestBuilders.get("/");
//        //3. Ask your mockMvc(nakli MVC) to make the request and get the result
//        MvcResult result=mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response=result.getResponse();
//        // Let's see if test passes or fails....(By comparing the returned values)
//        Assertions.assertEquals("index",response.getForwardedUrl());
//
//    }
//    @Test
//    public void testTheUserController() throws Exception{
//        // Let's define two parameters....username and password
//        String username="Hitesh";
//        String password="Hites@123";
//        Mockito.when(userService.checkUser(any(User.class))).thenReturn(null);
//        RequestBuilder requestBuilder=MockMvcRequestBuilders.post("/user/login")
//                .param("username",username).param("password",password);
//        MvcResult result=mockMvc.perform(requestBuilder).andReturn();
//        MockHttpServletResponse response=result.getResponse();
//        Assertions.assertEquals("user/login",response.getForwardedUrl());
//    }
//
//}
