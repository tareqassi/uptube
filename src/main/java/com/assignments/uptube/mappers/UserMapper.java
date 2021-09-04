package com.assignments.uptube.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.assignments.uptube.messages.UserDetails;
import com.assignments.uptube.models.User;

@Mapper
public interface UserMapper {

	public UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

	public UserDetails fromEntity(User source);

	public User toEntity(UserDetails target);

	public List<UserDetails> fromEntities(List<User> source);

	public List<User> toEntities(List<UserDetails> target);

}
