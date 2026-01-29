INSERT INTO PATIENT (name, gender, birth_date, email, blood_group)
VALUES
    ('Aarav Sharma', 'MALE', '1990-05-10', 'aarav.sharma@example.com', 'O_POSITIVE'),
    ('Priya Verma', 'FEMALE', '1995-08-22', 'priya.verma@example.com', 'A_POSITIVE'),
    ('Rohit Patil', 'MALE', '1988-12-03', 'rohit.patil@example.com', 'B_POSITIVE'),
    ('Neha Kulkarni', 'FEMALE', '1992-03-17', 'neha.kulkarni@example.com', 'AB_POSITIVE'),
    ('Karan Mehta', 'MALE', '1985-07-29', 'karan.mehta@example.com', 'O_NEGATIVE'),
    ('Sneha Joshi', 'FEMALE', '1998-11-11', 'sneha.joshi@example.com', 'A_NEGATIVE')
    ON CONFLICT (email) DO NOTHING;


INSERT INTO doctor (name, specialization, email)
VALUES
    ('Dr. Rakesh Mehta', 'Cardiology', 'rakesh.mehta@example.com'),
    ('Dr. Anjali Deshpande', 'Neurology', 'anjali.deshpande@example.com'),
    ('Dr. Amit Kulkarni', 'Orthopedics', 'amit.kulkarni@example.com'),
    ('Dr. Neha Joshi', 'Gynecology', 'neha.joshi@example.com'),
    ('Dr. Rahul Verma', 'General Medicine', 'rahul.verma@example.com'),
    ('Dr. Pooja Sharma', 'Pediatrics', 'pooja.sharma@example.com');

INSERT INTO appointment (appointment_time, reason, doctor_id, patient_id)
VALUES
    ('2025-07-01 10:30:00', 'General Checkup', 1, 2),
    ('2025-07-01 11:15:00', 'Chest Pain Consultation', 1, 3),
    ('2025-07-02 09:45:00', 'Knee Pain', 3, 4),
    ('2025-07-02 12:00:00', 'Skin Allergy', 5, 1),
    ('2025-07-03 10:00:00', 'Child Fever', 4, 6),
    ('2025-07-03 14:30:00', 'Migraine Follow-up', 1, 5),
    ('2025-07-04 11:00:00', 'Routine Health Check', 2, 2);