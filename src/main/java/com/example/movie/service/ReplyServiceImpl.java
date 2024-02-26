package com.example.movie.service;

import com.example.movie.dto.PageResultDTO;
import com.example.movie.dto.ReplyDTO;
import com.example.movie.entity.Reply;
import com.example.movie.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService, ConvertService{
    private final ReplyRepository replyRepository;
    //private final ConvertEnAndDto convertEnAndDto;
    @Override
    public PageResultDTO<ReplyDTO, Object[]> getReplyList(Long mno, int page) {
        Pageable pageable = PageRequest.of(page, 6);
        Page<Object[]> replyPage = replyRepository.getReplyList(mno, pageable);

        Function<Object[], ReplyDTO> fn = reply ->
                ReplyDTO.builder()
                        .rno((Long) reply[0])
                        .content((String) reply[1])
                        .grade((Long) reply[2])
                        .memberId((String) reply[3]).build();

        return new PageResultDTO<>(replyPage, fn);
    }

    @Override
    public void ReplyRegister(ReplyDTO replyDTO) {
        replyRepository.save(DtoToEntity(replyDTO));
    }

    @Override
    public Long getTotalGrade(Long mno) {
        return replyRepository.getTotalGrade(mno);
    }
}
