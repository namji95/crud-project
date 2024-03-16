package com.sparta.crud5.controller;

import com.sparta.crud5.dto.MusicMachineRequestDto;
import com.sparta.crud5.dto.MusicMachineResponseDto;
import com.sparta.crud5.service.MusicMachineService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.patterns.HasMemberTypePatternForPerThisMatching;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/musics")
public class MusicMachineController {

  private final MusicMachineService service;

  @PostMapping
  public String createMusic (
      @RequestBody MusicMachineRequestDto requestDto) {
    service.createMusic(requestDto);

    return "음악이 생성되었습니다.";
  }

  @GetMapping
  public ResponseEntity<List<MusicMachineResponseDto>> getMusicList () {
    List<MusicMachineResponseDto> responseDto = service.getMusicList();

    return new ResponseEntity<>(responseDto, HttpStatus.OK);
  }

  @GetMapping("/{musicId}")
  public ResponseEntity<MusicMachineResponseDto> getMusic (
      @PathVariable Long musicId) {
    MusicMachineResponseDto responseDto = service.getMusic(musicId);

    return new ResponseEntity<>(responseDto, HttpStatus.OK);
  }

  @PutMapping("/{musicId}")
  public String updateMusic (
      @RequestBody MusicMachineRequestDto requestDto,
      @PathVariable Long musicId) {
    service.updateMusic (requestDto, musicId);

    return "음악 정보가 수정되었습니다ㅣ";
  }

  @DeleteMapping("/{musicId}")
  public String deleteMusic (
      @PathVariable Long musicId) {
    service.deleteMusic(musicId);

    return "음악 정보를 삭제했습니다.";
  }
}
