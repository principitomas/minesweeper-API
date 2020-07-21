package com.hiringtest.minesweeper.api;

import com.hiringtest.minesweeper.domain.game.Game;
import com.hiringtest.minesweeper.domain.useraccount.UserAccount;
import com.hiringtest.minesweeper.service.useraccount.UserAccountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
public class UserAccountsResource {

    @Autowired
    UserAccountService userAccountService;


    @ApiOperation(value = "Creates a new user account.", response = UserAccount.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "User Account successfully created.")
    })
    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    public Response register(@RequestBody UserAccount userAccount) {
        UserAccount createdUserAccount = userAccountService.add(userAccount);
        return Response.status(Response.Status.CREATED).entity(createdUserAccount).build();
    }
}
