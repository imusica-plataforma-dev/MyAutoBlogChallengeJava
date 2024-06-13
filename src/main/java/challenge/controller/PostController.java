package challenge.controller;

import challenge.model.Post;
import challenge.model.User;
import challenge.security.AuthenticationFacade;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import challenge.repository.PostRepository;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PostController {

	@Autowired
	private PostRepository repository;

	@Autowired
	private AuthenticationFacade authentication;

	@GetMapping("/posts")
	public List<Post> listPosts(@Valid @RequestBody Post post) {
		return Lists.newArrayList(repository.findAll());
	}

	@PostMapping("/posts")
	public Post newPost(@Valid @RequestBody Post post) {
		post.setUser(authentication.getUser());
		return repository.save(post);
	}

}
