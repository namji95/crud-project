package com.sparta.crud5.service;

import com.sparta.crud5.dto.MusicMachineRequestDto;
import com.sparta.crud5.dto.MusicMachineResponseDto;
import com.sparta.crud5.entity.MusicMachine;
import com.sparta.crud5.repository.MusicMachineRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MusicMachineService {

  private final MusicMachineRepository repository;

  @Transactional
  public void createMusic(MusicMachineRequestDto requestDto) {
    MusicMachine machine = new MusicMachine(requestDto);

    repository.save(machine);
  }

  @Transactional(readOnly = true)
  public List<MusicMachineResponseDto> getMusicList() {
    List<MusicMachine> machines = repository.findAll();
    List<MusicMachineResponseDto> responseDtos = machines.stream().map(
        machine -> new MusicMachineResponseDto(
            machine.getSingNumber(), machine.getSingTitle(), machine.getSinger())).toList();

    return responseDtos;
  }

  @Transactional(readOnly = true)
  public MusicMachineResponseDto getMusic(Long musicId) {
    MusicMachine machine = repository.findById(musicId).orElseThrow(() ->
        new IllegalArgumentException("존재하지 않는 음악입니다."));

    MusicMachineResponseDto responseDto = new MusicMachineResponseDto(
        machine.getSingNumber(), machine.getSingTitle(), machine.getSinger());

    return responseDto;
  }

  @Transactional
  public void updateMusic(MusicMachineRequestDto requestDto, Long musicId) {
    MusicMachine machine = repository.findById(musicId).orElseThrow(() ->
        new IllegalArgumentException("존재하는 않는 음악입니다."));

    machine.updateMusic(requestDto);
  }

  @Transactional
  public void deleteMusic(Long musicId) {
    repository.deleteById(musicId);
  }
}
