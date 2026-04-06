package in.srikanth.EmployeeAuthentication.controller;

import in.srikanth.EmployeeAuthentication.io.ProfileRequest;
import in.srikanth.EmployeeAuthentication.io.ProfileResponse;
import in.srikanth.EmployeeAuthentication.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0")
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@RequestBody ProfileRequest request){
        ProfileResponse response = profileService.createProfile(request);

        return response;

    }
}
