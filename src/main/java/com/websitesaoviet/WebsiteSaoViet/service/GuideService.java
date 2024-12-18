package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.GuideCreationRequest;
import com.websitesaoviet.WebsiteSaoViet.dto.request.GuideUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Guide;
import com.websitesaoviet.WebsiteSaoViet.repository.GuideRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class GuideService {
    GuideRepository guideRepository;

    public Guide createGuide(GuideCreationRequest request) {
        Guide guide = new Guide();

        guide.setTenHDV(request.getTenHDV());
        guide.setAnhHDV(request.getAnhHDV());
        guide.setGioiTinh(request.getGioiTinh());
        guide.setNgaySinh(request.getNgaySinh());
        guide.setSDT(request.getSDT());
        guide.setEmail(request.getEmail());
        guide.setMoTa(request.getMoTa());
        guide.setDanhGia(request.getDanhGia());

        return guideRepository.save(guide);
    }

    public List<Guide> getGuides() {
        return guideRepository.findAll();
    }

    public Guide getGuideById(String id) {
        return guideRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hướng dẫn viên không hợp lệ!"));
    }

    public Guide updateAccount(String id, GuideUpdateRequest request) {
        Guide guide = getGuideById(id);

        guide.setTenHDV(request.getTenHDV());
        guide.setGioiTinh(request.getGioiTinh());
        guide.setNgaySinh(request.getNgaySinh());
        guide.setSDT(request.getSDT());
        guide.setEmail(request.getEmail());
        guide.setMoTa(request.getMoTa());
        guide.setDanhGia(request.getDanhGia());

        if(request.getAnhHDV() != null && !request.getAnhHDV().isEmpty()) {
            guide.setAnhHDV(request.getAnhHDV());
        }

        return guideRepository.save(guide);
    }

    public void deleteGuide(String id) {
        guideRepository.deleteById(id);
    }
}
