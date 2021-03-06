package delta.codecharacter.server.controller.api;

import delta.codecharacter.server.controller.request.Simulation.SimulateMatchRequest;
import delta.codecharacter.server.service.SimulationService;
import delta.codecharacter.server.service.UserService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class SimulationController {

    private final Logger LOG = Logger.getLogger(SimulationController.class.getName());

    @Autowired
    private SimulationService simulationService;

    @Autowired
    private UserService userService;

    @SneakyThrows
    @MessageMapping("/match")
    public void simulateMatch(@RequestBody @Valid SimulateMatchRequest simulateMatchRequest, Authentication authentication) {
        if (!userService.isEmailPresent(userService.getEmailFromAuthentication(authentication)))
            throw new Exception("Invalid Login");
        simulationService.simulateMatch(simulateMatchRequest);
    }

}
