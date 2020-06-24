package exampreparation.service.impl;

import exampreparation.model.entity.User;
import exampreparation.model.serviceModels.UserServiceModel;
import exampreparation.repository.UserRepository;
import exampreparation.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserServiceModel register(UserServiceModel userServiceModel) {

        if (findByUsername(userServiceModel.getUsername()) == null){
            User user = this.modelMapper.map(userServiceModel, User.class);
            this.userRepository.saveAndFlush(user);
        }


        return userServiceModel;
    }

    @Override
    public UserServiceModel findByUsername(String username) {

        return this.userRepository.findByUsername(username).map(user ->
                this.modelMapper.map(user, UserServiceModel.class)).orElse(null);
    }
}
