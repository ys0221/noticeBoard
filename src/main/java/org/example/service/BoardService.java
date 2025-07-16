package org.example.service;

import org.example.model.Post;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class BoardService {
    private final Map<String, String> board = new HashMap<>();

    public List<Post> getAllPosts() {
        List<Post> result = new ArrayList<>();
        for (Map.Entry<String, String> entry : board.entrySet()) {
            result.add(new Post(entry.getKey(), entry.getValue()));
        }
        return result;
    }

    public boolean createPost(Post post) {
        if (board.containsKey(post.getTitle())) return false;
        board.put(post.getTitle(), post.getContent());
        return true;
    }

    public boolean updatePost(String oldTitle, Post newPost) {
        if (!board.containsKey(oldTitle)) return false;
        board.remove(oldTitle);
        board.put(newPost.getTitle(), newPost.getContent());
        return true;
    }

    public boolean deletePost(String title) {
        return board.remove(title) != null;
    }
}