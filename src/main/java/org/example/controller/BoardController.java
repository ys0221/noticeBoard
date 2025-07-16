package org.example.controller;
import org.example.model.Post;
import org.example.service.BoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin  // CORS 허용 (JS fetch API 연결용)
public class BoardController {
    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    public List<Post> getAll() {
        return boardService.getAllPosts();
    }

    @PostMapping
    public boolean create(@RequestBody Post post) {
        return boardService.createPost(post);
    }

    @PutMapping("/{oldTitle}")
    public boolean update(@PathVariable String oldTitle, @RequestBody Post newPost) {
        return boardService.updatePost(oldTitle, newPost);
    }

    @DeleteMapping("/{title}")
    public boolean delete(@PathVariable String title) {
        return boardService.deletePost(title);
    }
}
