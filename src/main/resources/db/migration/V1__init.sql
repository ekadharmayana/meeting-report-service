CREATE TABLE meetings (
                          id BIGINT NOT NULL AUTO_INCREMENT,
                          title VARCHAR(255) NOT NULL,
                          organizer_email VARCHAR(255) NULL,
                          start_time DATETIME NOT NULL,
                          end_time DATETIME NULL,
                          created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                          updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                          PRIMARY KEY (id)
);

CREATE TABLE participants (
                              id BIGINT NOT NULL AUTO_INCREMENT,
                              display_name VARCHAR(255) NOT NULL,
                              email VARCHAR(255) NOT NULL,
                              created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                              updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                              PRIMARY KEY (id),
                              UNIQUE KEY uk_participants_email (email)
);

CREATE TABLE attendance (
                            id BIGINT NOT NULL AUTO_INCREMENT,
                            meeting_id BIGINT NOT NULL,
                            participant_id BIGINT NOT NULL,
                            join_time DATETIME NOT NULL,
                            leave_time DATETIME NULL,
                            duration_minutes INT NULL,
                            created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
                            updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
                            PRIMARY KEY (id),
                            CONSTRAINT fk_attendance_meeting FOREIGN KEY (meeting_id) REFERENCES meetings(id),
                            CONSTRAINT fk_attendance_participant FOREIGN KEY (participant_id) REFERENCES participants(id),
                            UNIQUE KEY uk_attendance_meeting_participant_join (meeting_id, participant_id, join_time)
);
