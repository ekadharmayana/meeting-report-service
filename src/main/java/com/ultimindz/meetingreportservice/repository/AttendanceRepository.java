package com.ultimindz.meetingreportservice.repository;

import com.ultimindz.meetingreportservice.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
}
