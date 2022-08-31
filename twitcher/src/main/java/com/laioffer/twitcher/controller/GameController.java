package com.laioffer.twitcher.controller;

import com.laioffer.twitcher.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.laioffer.twitcher.service.GameService;
import com.laioffer.twitcher.service.TwitchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@Controller
public class GameController {

//    @Autowired
    private GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }


    // /game?game_name=whatever
    // /game
    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public void getGame(@RequestParam(value = "game_name", required = false) String gameName, HttpServletResponse response) throws IOException,ServletException {
        response.setContentType("application/json;charset=UTF-8");
        try {
            // Return the dedicated game information if gameName is provided in the request URL, otherwise return the top x games.
//            if (gameName != null) {
//                response.getWriter().print(new ObjectMapper().writeValueAsString(gameService.searchGame(gameName)));
//            } else {
//                response.getWriter().print(new ObjectMapper().writeValueAsString(gameService.topGames(0)));
//            }
            response.getWriter().print(new ObjectMapper().writeValueAsString(gameName==null?gameService.topGames(0):gameService.searchGame(gameName)));
        } catch (TwitchException e) {
            throw new ServletException(e);
        }

    }

}
