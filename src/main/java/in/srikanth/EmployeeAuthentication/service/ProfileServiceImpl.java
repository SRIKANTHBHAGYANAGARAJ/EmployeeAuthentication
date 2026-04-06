package in.srikanth.EmployeeAuthentication.service;


import in.srikanth.EmployeeAuthentication.entity.UserEntity;
import in.srikanth.EmployeeAuthentication.io.ProfileRequest;
import in.srikanth.EmployeeAuthentication.io.ProfileResponse;
import in.srikanth.EmployeeAuthentication.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl extends ProfileService {
    private final UserRepository userRepository;


    @Override
    public ProfileResponse createProfile(ProfileRequest request) {
      UserEntity newProfile = convertToUserEntity(request);
        newProfile=userRepository.save(newProfile);
        return convertToProfileResponse(newProfile);



    }

    private ProfileResponse convertToProfileResponse(UserEntity newProfile) {
        return ProfileResponse.builder()
                .name(newProfile.getName())
                .email(newProfile.getEmail())
                .userId(newProfile.getUserId())
                .isAccountVerified(newProfile.getIsAccountVerified())
                .build();
    }

    private UserEntity convertToUserEntity(ProfileRequest request) {
       return UserEntity.builder()
                .email(request.getEmail())
                .userId(UUID.randomUUID().toString())
                .name(request.getName())
                .password(request.getPassword())
                .isAccountVerified(false)
                .resetOtp(null)
                .resetOtpExpireAt(0L)
                .build();
    }

}