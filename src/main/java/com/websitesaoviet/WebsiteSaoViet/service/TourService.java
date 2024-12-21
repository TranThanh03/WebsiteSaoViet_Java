package com.websitesaoviet.WebsiteSaoViet.service;

import com.websitesaoviet.WebsiteSaoViet.dto.request.TourUpdateRequest;
import com.websitesaoviet.WebsiteSaoViet.entity.Tour;
import com.websitesaoviet.WebsiteSaoViet.repository.TourRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.NonFinal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Service
public class TourService {
    TourRepository tourRepository;

    @NonFinal
    @Value("${file.uploadTourDir}")
    protected String uploadDir;

    public Tour createTour(String TenTour, String GioiThieu,
                           int MaCD, MultipartFile AnhTour,
                           String MoTa, String Gia) {
        try {
            String uploadDirPath = new File(uploadDir).getAbsolutePath();
            Path path = Paths.get(uploadDirPath, AnhTour.getOriginalFilename());
            File file = path.toFile();

            if (!file.exists()) {
                AnhTour.transferTo(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        Tour tour = new Tour();

        tour.setTentour(TenTour);
        tour.setGioithieu(GioiThieu);
        tour.setMacd(MaCD);
        tour.setAnhtour(AnhTour.getOriginalFilename());
        tour.setMota(MoTa);
        tour.setGiatour(Gia);
        tour.setNgaytao(LocalDateTime.now());

        return tourRepository.save(tour);
    }

    public List<Tour> getTours() {
        return tourRepository.findAll();
    }

    public Tour getTourById(String id) {
        return tourRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tour không hợp lệ!"));
    }

    public Tour updateTour(String id, TourUpdateRequest request) {
        Tour tour = getTourById(id);

//        tour.setTenTour(request.getTenTour());
//        tour.setGioiThieu(request.getGioiThieu());
//        tour.setMoTa(request.getMoTa());
//        tour.setMaCD(request.getMaCD());
//        tour.setGiaTour(request.getGiaTour());
//
//        if(request.getAnhTour() != null && !request.getAnhTour().isEmpty()) {
//            tour.setAnhTour(request.getAnhTour());
//        }

        return tourRepository.save(tour);
    }

    public void deleteTour(String id) {
        tourRepository.deleteById(id);
    }

    public List<Tour> getTourLatest() {
        Pageable pageable = PageRequest.of(0, 12);

        return tourRepository.findToursLatest(pageable);
    }

    public List<Tour> getToursByTopic(int id) {
        return tourRepository.findToursByTopic(id);
    }
}
