package com.doggy.board;

import com.doggy.member.Member;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 회원 등록, 조회, 수정(이름, 비밀번호), 삭제
    public Integer saveBoard(Board board) {
        boardRepository.save(board);
        return board.getId();
    }

    public Board selectBoard(Integer boardId) {
        Board findBoard = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalStateException("잘못된 id"));
        return findBoard;
    }

    public Integer updateBoard(Integer boardId, String title, String contents) {
        selectBoard(boardId).updateBoard(title, contents);
        return boardId;
    }

    public Integer deleteBoard(Integer boardId) {
        Board findBoard = selectBoard(boardId);
        boardRepository.delete(findBoard);
        return boardId;
    }
}
