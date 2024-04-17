package ru.yandex.test_task.controllers;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.yandex.test_task.dto.courier.CourierDto;
import ru.yandex.test_task.dto.courier.CreateCourierRequest;
import ru.yandex.test_task.dto.courier.GetCourierRatingRequest;
import ru.yandex.test_task.dto.courier.GetCourierRatingResponse;
import ru.yandex.test_task.dto.courier.CreateCourierResponse;
import ru.yandex.test_task.dto.courier.GetCouriersResponse;
import ru.yandex.test_task.service.CourierService;

import java.math.BigInteger;
import java.time.Duration;

@RestController
@RequestMapping("/couriers")
public class CourierController {
    private final CourierService courierService;
    public CourierController(CourierService courierService) {

        this.courierService = courierService;
    }

    @PostMapping("/")
    public ResponseEntity<CreateCourierResponse> createCouriers(@RequestBody CreateCourierRequest createCourierRequest) {
        return ResponseEntity.ok(courierService.createCouriers(createCourierRequest));
    }

    @GetMapping("/")
    public ResponseEntity<GetCouriersResponse> getCouriersWithRestrictions(@RequestParam(defaultValue = "0") BigInteger offset,
                                                                           @RequestParam(defaultValue = "1") BigInteger limit) {
        return ResponseEntity.ok(courierService.getCouriersWithRestrictions(offset, limit));
    }

    @GetMapping("/{courier_id}")
    public ResponseEntity<CourierDto> getCourierById(@PathVariable BigInteger courier_id) {
        return ResponseEntity.ok(courierService.getCourierById(courier_id));
    }

    @GetMapping("/meta-info/{courier_id}")
    public ResponseEntity<GetCourierRatingResponse> getCourierRating(@PathVariable String courier_id,
                                                                     @RequestBody GetCourierRatingRequest getCourierRatingRequest) {
        return ResponseEntity.ok(courierService.getCourierRating(courier_id, getCourierRatingRequest));
    }
}
