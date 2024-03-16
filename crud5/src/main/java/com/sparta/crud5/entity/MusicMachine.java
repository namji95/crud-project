package com.sparta.crud5.entity;

import com.sparta.crud5.dto.MusicMachineRequestDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "musics")
@NoArgsConstructor
@Getter
public class MusicMachine {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long singNumber;
  private String singTitle;
  private String singer;

  private LocalDateTime createdAt;
  private LocalDateTime modifiedAt;

  public MusicMachine(MusicMachineRequestDto requestDto) {
    this.singNumber = requestDto.getSingNumber();
    this.singTitle = requestDto.getSingTitle();
    this.singer = requestDto.getSinger();
    this.createdAt = LocalDateTime.now();
  }

  public void updateMusic(MusicMachineRequestDto responseDto) {
    this.singNumber = responseDto.getSingNumber();
    this.singTitle = responseDto.getSingTitle();
    this.singer = responseDto.getSinger();
    this.modifiedAt = LocalDateTime.now();
  }
}
