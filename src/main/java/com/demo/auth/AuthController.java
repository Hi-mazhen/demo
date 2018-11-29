//package com.demo.auth;
//
//import com.demo.entity.User;
//import com.demo.secruity.JwtAuthenticationRequest;
//import com.demo.secruity.JwtAuthenticationResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.naming.AuthenticationException;
//import javax.servlet.http.HttpServletRequest;
//
//@RestController
//public class AuthController {
//    @Value("${jwt.header}")
//    private String tokenHeader;
//
//    @Autowired
//    private AuthService authService;
//
//    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
//    public ResponseEntity<?> createAuthenticationToken(
//            @RequestBody JwtAuthenticationRequest authenticationRequest) throws AuthenticationException{
//        final String token = authService.login(authenticationRequest.getUsername(), authenticationRequest.getPassword());
//
//        // Return the token
//        System.out.println(token);
//        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
//    }
//
//    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
//    public ResponseEntity<?> refreshAndGetAuthenticationToken(
//            HttpServletRequest request) throws AuthenticationException {
//        System.out.println(11);
//        String token = request.getHeader(tokenHeader);
//        System.out.println(token);
//        String refreshedToken = authService.refresh(token);
//        System.out.println(refreshedToken);
//        if(refreshedToken == null) {
//            System.out.println("token 为空！---" + ResponseEntity.badRequest().body(null));
//            return ResponseEntity.badRequest().body(null);
//        } else {
//            System.out.println("新token！---" + ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken)));
//            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
//        }
//    }
//
//    @RequestMapping(value = "${jwt.route.authentication.register}", method = RequestMethod.POST)
//    public User register(@RequestBody User addedUser) throws AuthenticationException{
//        return authService.register(addedUser);
//    }
//}
