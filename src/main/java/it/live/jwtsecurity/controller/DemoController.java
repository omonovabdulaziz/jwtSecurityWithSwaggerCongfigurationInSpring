package it.live.jwtsecurity.controller;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.live.jwtsecurity.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/demo-controller")
@Tag(name = "Demo")
public class DemoController {
    @Operation(
            description = "Get endpoint for user",
            summary = "This is summary of user which get endpoint",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "UnAuthorized",
                            responseCode = "403"
                    )
            }
    )
    @PostMapping
    public ResponseEntity<String> sayHello(@RequestBody User user){
        return ResponseEntity.ok("hello from secured endPoint");
    }
}
