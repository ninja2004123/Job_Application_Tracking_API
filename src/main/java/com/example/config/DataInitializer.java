package com.example.config;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.model.Application;
import com.example.model.Candidate;
import com.example.model.Conducts;
import com.example.model.Employee;
import com.example.model.Interview;
import com.example.model.Job;
import com.example.model.Offer;
import com.example.repository.ApplicationRepository;
import com.example.repository.CandidateRepository;
import com.example.repository.ConductsRepository;
import com.example.repository.EmployeeRepository;
import com.example.repository.InterviewRepository;
import com.example.repository.JobRepository;
import com.example.repository.OfferRepository;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(CandidateRepository candidateRepo,
                               JobRepository jobRepo,
                               ApplicationRepository applicationRepo,
                               EmployeeRepository employeeRepo,
                               InterviewRepository interviewRepo,
                               ConductsRepository conductsRepo,
                               OfferRepository offerRepo) {
        return args -> {
            // Only run if DB is empty (you can customize this condition)
            if (jobRepo.count() > 0 || candidateRepo.count() > 0 || employeeRepo.count() > 0) {
                System.out.println("Database already contains data. Skipping initialization.");
                return;
            }

            // Employees
            Employee e1 = new Employee("Alice", "Morgan", "alice.morgan@paytech.com", "HR Manager");
            Employee e2 = new Employee("Mark", "Davison", "mark.davison@playtech.com", "Java Developer");
            Employee e3 = new Employee("Jenna", "Patel", "jenna.patel@youtube.com", "HR Assistant");
            Employee e4 = new Employee("Leo", "Zhang", "leo.zhang@glassbox.com", "HR Manager");
            employeeRepo.saveAll(Arrays.asList(e1, e2, e3, e4));

            // Candidates
            Candidate c1 = new Candidate("Anna", "Petrova", "anna.petrova@gmail.com", "https://resume.com/anna-petrova", "https://linkedin.com/in/anna-petrova", "Java, Spring, SQL");
            Candidate c2 = new Candidate("Sofia", "Marku", "sofia.marku@hotmail.com", "https://resume.com/sofia-marku", "https://linkedin.com/in/sofia-marku", "Manual Testing, Selenium, JIRA");
            Candidate c3 = new Candidate("Liam", "Ivankov", "liam.ivankov@email.com", "https://resume.com/liam-ivankov", "https://linkedin.com/in/liam-ivankov", "Python, Django, PostgreSQL");
            Candidate c4 = new Candidate("Elena", "Jovanovic", "elena.jovanovic@email.com", "https://resume.com/elena-jovanovic", "https://linkedin.com/in/elena-jovanovic", "Java, REST APIs, Git");
            Candidate c5 = new Candidate("James", "O’Connor", "j.oconnor@email.com", "https://resume.com/james-oconnor", "https://linkedin.com/in/james-oconnor", "AWS, Kubernetes, DevOps");
            Candidate c6 = new Candidate("Noah", "Tanaka", "noah.tanaka@email.com", "https://resume.com/noah-tanaka", "https://linkedin.com/in/noah-tanaka", "C++, Python, Algorithms");
            Candidate c7 = new Candidate("Olivia", "Stojanovska", "olivia.stojanovska@email.com", "https://resume.com/olivia-stojanovska", "https://linkedin.com/in/olivia-stojanovska", "HTML, CSS, Figma");
            Candidate c8 = new Candidate("David", "Ramirez", "david.ramirez@email.com", "https://resume.com/david-ramirez", "https://linkedin.com/in/david-ramirez", "React Native, TypeScript, Firebase");
            Candidate c9 = new Candidate("Ema", "Milic", "ema.milic@email.com", "https://resume.com/ema-milic", "https://linkedin.com/in/ema-milic", "SQL, ETL, Data Warehousing");
            Candidate c10 = new Candidate("Michael", "Nguyen", "m.nguyen@email.com", "https://resume.com/michael-nguyen", "https://linkedin.com/in/michael-nguyen", "React, JavaScript, HTML/CSS");
            Candidate c11 = new Candidate("Sara", "Yamada", "s.yamada@email.com", "https://resume.com/sara-yamada", "https://linkedin.com/in/sara-yamada", "Data Science, Pandas, NumPy");
            Candidate c12 = new Candidate("Lucas", "Kowalski", "lucas.kowalski@email.com", "https://resume.com/lucas-kowalski", "https://linkedin.com/in/lucas-kowalski", "Spring Boot, Hibernate, Docker");
            candidateRepo.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12));

            // Jobs
            Job j1 = new Job(
                "Junior Java Software Engineer",
                "Junior Java Software Engineer at PlayTech.",
                "Knowledge of Java, Bachlors Degree in Computer Science",
                "Skopje",
                Set.of(Job.EmploymentType.FULL_TIME)
            );
            
            Job j2 = new Job(
                "Manual QA Tester",
                "Entry-level QA Tester for financial software.",
                "Basic knowledge of testing tools, ISTQB certification is a plus",
                "Bitola",
                Set.of(Job.EmploymentType.FULL_TIME, Job.EmploymentType.PART_TIME)
            );

            Job j3 = new Job(
                "Frontend Developer",
                "React Developer to build modern UI components.",
                "React, HTML/CSS, JavaScript experience required",
                "Ohrid",
                Set.of(Job.EmploymentType.PART_TIME, Job.EmploymentType.CONTRACT)
            );
            
            Job j4 = new Job(
                "Python Backend Developer",
                "Work with Django and REST APIs for our healthcare platform.",
                "Python, Django, REST, PostgreSQL",
                "Skopje",
                Set.of(Job.EmploymentType.PART_TIME, Job.EmploymentType.CONTRACT)
            );

            Job j5 = new Job(
                "DevOps Engineer",
                "Automate and monitor cloud-based infrastructure.",
                "Experience with AWS, CI/CD, Kubernetes",
                "Prilep",
                Set.of(Job.EmploymentType.PART_TIME, Job.EmploymentType.CONTRACT)
            );

            Job j6 = new Job(
                "Mobile App Developer",
                "React Native developer for mobile e-commerce app.",
                "React Native, Firebase, Git",
                "Skopje",
                Set.of(Job.EmploymentType.CONTRACT)
            );

            Job j7 = new Job(
                "Data Analyst",
                "Work with ETL pipelines and data visualization.",
                "SQL, ETL, Power BI or Tableau",
                "Tetovo",
                Set.of(Job.EmploymentType.FULL_TIME, Job.EmploymentType.CONTRACT)
            );

            Job j8 = new Job(
                "Cloud Support Engineer",
                "Provide technical support for AWS-based systems.",
                "AWS certifications, Linux, scripting knowledge",
                "Gostivar",
                Set.of(Job.EmploymentType.FULL_TIME, Job.EmploymentType.PART_TIME, Job.EmploymentType.CONTRACT)
            );

            Job j9 = new Job(
                "UI/UX Designer",
                "Design user-friendly interfaces for mobile/web apps.",
                "Figma, Adobe XD, UI/UX principles",
                "Kumanovo",
                Set.of(Job.EmploymentType.PART_TIME)
            );

            Job j10 = new Job(
                "Full Stack Engineer",
                "Work on full-stack development of HR tools.",
                "Java, Spring Boot, React, SQL",
                "Skopje",
                Set.of(Job.EmploymentType.FULL_TIME, Job.EmploymentType.PART_TIME)
            );
            jobRepo.saveAll(Arrays.asList(j1, j2, j3, j4, j5, j6, j7, j8, j9, j10));

            // Applications
            Application a1 = new Application(c1, j1, Application.Status.SUBMITTED);
            Application a2 = new Application(c1, j2, Application.Status.WITHDRAWN);
            Application a3 = new Application(c3, j3, Application.Status.SUBMITTED);
            Application a4 = new Application(c2, j5, Application.Status.REJECTED);
            Application a5 = new Application(c4, j1, Application.Status.INTERVIEW_SCHEDULED);
            Application a6 = new Application(c5, j4, Application.Status.INTERVIEW_SCHEDULED);
            Application a7 = new Application(c6, j2, Application.Status.REJECTED);
            Application a8 = new Application(c7, j6, Application.Status.INTERVIEW_SCHEDULED);
            Application a9 = new Application(c8, j7, Application.Status.WITHDRAWN);
            Application a10 = new Application(c9, j3, Application.Status.INTERVIEW_SCHEDULED);
            Application a11 = new Application(c10, j8, Application.Status.SUBMITTED);
            Application a12 = new Application(c5, j5, Application.Status.SUBMITTED);
            Application a13 = new Application(c7, j9, Application.Status.REJECTED);
            Application a14 = new Application(c8, j10, Application.Status.SUBMITTED);
            applicationRepo.saveAll(Arrays.asList(a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14));
            
            Interview i1 = new Interview(a5, LocalDateTime.of(2025, 6, 5, 10, 0), "Conference Room A", Interview.Status.SCHEDULED, "https://notes.com/interview1");
            Interview i2 = new Interview(a6, LocalDateTime.of(2025, 6, 6, 11, 30), "Online - Zoom", Interview.Status.SCHEDULED, "https://notes.com/interview2");
            Interview i3 = new Interview(a8, LocalDateTime.of(2025, 6, 7, 9, 15), "Conference Room B", Interview.Status.COMPLETED, "https://notes.com/interview3");
            Interview i4 = new Interview(a10, LocalDateTime.of(2025, 6, 8, 14, 0), "Online - Teams", Interview.Status.CANCELLED, "https://notes.com/interview4");
            interviewRepo.saveAll(Arrays.asList(i1, i2, i3, i4));

            Conducts co1 = new Conducts(i1, e1);
            Conducts co2 = new Conducts(i1, e2);
            Conducts co3 = new Conducts(i2, e2);
            Conducts co4 = new Conducts(i3, e3);
            Conducts co5 = new Conducts(i4, e4);
            conductsRepo.saveAll(Arrays.asList(co1, co2, co3, co4, co5));

            Offer o1 = new Offer(a6, 55000, LocalDateTime.of(2025, 7, 1, 9, 0),
                    "https://contracts.com/offer-a1.pdf", LocalDateTime.of(2025, 6, 5, 14, 30));

            Offer o2 = new Offer(a7, 60000, LocalDateTime.of(2025, 8, 1, 9, 0),
                    "https://contracts.com/offer-a3.pdf", LocalDateTime.of(2025, 6, 7, 10, 15));

            Offer o3 = new Offer(a10, 52000, LocalDateTime.of(2025, 7, 15, 9, 0),
                    "https://contracts.com/offer-a6.pdf", LocalDateTime.of(2025, 6, 6, 11, 45));
            offerRepo.saveAll(Arrays.asList(o1, o2, o3));
        };
    }
}
