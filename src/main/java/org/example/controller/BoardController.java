package org.example.controller;
import org.example.model.Post;
import jakarta.validation.Valid;
import org.example.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin
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
    public ResponseEntity<?> create(@RequestBody @Valid Post post) {
        boolean success = boardService.createPost(post);
        if (!success) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("이미 존재하는 제목입니다.");
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{oldTitle}")
    public ResponseEntity<?> update(@PathVariable String oldTitle, @RequestBody @Valid Post post) {
        boolean success = boardService.updatePost(oldTitle, post);
        if (!success) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("수정할 게시물이 없습니다.");
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{title}")
    public ResponseEntity<?> delete(@PathVariable String title) {
        boolean success = boardService.deletePost(title);
        if (!success) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("삭제할 게시물이 없습니다.");
        }
        return ResponseEntity.ok().build();
    }
}
