package io.elice.shoppingmall.user.controller;

import io.elice.shoppingmall.user.service.RefreshService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RefreshController {
    private final RefreshService refreshService;

    @PostMapping("/reissue")
    public ResponseEntity<?> reissue(HttpServletRequest request, HttpServletResponse response){
        refreshService.reissueTokens(request, response);
<<<<<<< HEAD
        ResponseEntity<Object> objectResponseEntity = new ResponseEntity<>(HttpStatus.OK);
        return objectResponseEntity;
=======
        return new ResponseEntity<>(HttpStatus.OK);
>>>>>>> 3bd465834f53b723681605371ce84809a3467005
    }
}
