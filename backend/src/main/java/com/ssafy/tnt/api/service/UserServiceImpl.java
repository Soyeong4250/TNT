package com.ssafy.tnt.api.service;

import com.ssafy.tnt.api.request.UserRegisterPostReq;
import com.ssafy.tnt.api.request.UserUpdatePutReq;
import com.ssafy.tnt.db.entity.User;
import com.ssafy.tnt.db.repository.UserRepository;
import com.ssafy.tnt.db.repository.UserRepositorySupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Optional;

@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRepositorySupport userRepositorySupport;

    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * 만들어질 User의 정보를 받아와서 DB에 저장한다.
     */
    @Override
    public User createUser(UserRegisterPostReq userRegisterInfo) {
        User user= User.builder().userId(userRegisterInfo.getUser_id())
                .email(userRegisterInfo.getUser_email())
                .name(userRegisterInfo.getUser_name())
                .password(passwordEncoder.encode(userRegisterInfo.getUser_pwd()))
                .birth(userRegisterInfo.getUser_birth())
                .build();
        return userRepository.save(user);
    }

    /**
     * User ID를 이용하여 DB에서 User의 정보를 조회한다.
     */
    @Override
    public User getUserByUserId(String userId) {
        Optional<User> user = userRepositorySupport.findUserByUserId(userId);
        if(!user.isPresent()) return null;
        return user.get();
    }

    /**
     * User ID를 이용하여 DB에서 User의 정보를 삭제한다.
     */
    @Override
    public void deleteByUserId(String userId){
        userRepository.deleteByUserId(userId);
    }

    /**
     * 수정할 User의 정보를 받아온다.
     * User ID를 이용하여 DB에서 User의 정보를 수정한다.
     */
    @Override
    public User updateUser(String id, UserUpdatePutReq userUpdateInfo){
        Optional<User> pUser = userRepositorySupport.findUserByUserId(id);
        if(!pUser.isPresent()) return null;

        User user= pUser.get();
        user.setName(userUpdateInfo.getUser_name());
        user.setPassword(passwordEncoder.encode(userUpdateInfo.getUser_pwd()));
        return userRepository.save(user);
    }

    @Override
    public String getUserId(String name, String email){
        Optional<User> pUser = userRepository.findByNameAndEmail(name,email);
        if(!pUser.isPresent()) return null;

        User user=pUser.get();
        return user.getUserId();
    }

    @Override
    public String getRandomPassword() {
        char[] charSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '!', '@', '#', '$', '%', '^', '&' };

        StringBuilder stringBuilder=new StringBuilder();
        // 난수 생성을 위한 secureRandom 생성
        SecureRandom secureRandom=new SecureRandom();
        // 시드 설정
        secureRandom.setSeed(new Date().getTime());

        int idx=0;
        // 8자리 암호 생성
        for (int i = 0; i < 8; i++) {
            idx=secureRandom.nextInt(charSet.length);
            stringBuilder.append(charSet[idx]);
        }

        return stringBuilder.toString();
    }
}
