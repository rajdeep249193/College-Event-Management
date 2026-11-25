# Synopsis
## On
# CAMPUSLY: CAMPUS FEST & EVENT MANAGEMENT SYSTEM
### (UTTARANCHAL UNIVERSITY EVENT PORTAL)

**Submitted to the Uttaranchal University in partial fulfilment of the requirements for the award of the Degree of**  
### **BACHELOR OF COMPUTER APPLICATIONS**

---

**Submitted by:**  
**Student Name:** [Student Name]  
**(Learner ID:** [Learner ID / Roll Number]**)**  

**Under the Guidance of:**  
**Guide Name with Designation (Faculty Guide)**  
Department of Computer Applications  
Uttaranchal University, Dehradun  

---

<div align="center">
  <h3>UTTARANCHAL UNIVERSITY, DEHRADUN</h3>
  <p><strong>Arcadia Grant, P.O. Chandanwari, Prem Nagar, Dehradun, Uttarakhand 248007</strong></p>
  <p><strong>NAAC Grade A+ Accredited</strong></p>
</div>

\newpage

---

# Table of Contents

| S.No. | Topic | Page No. |
| :---: | :--- | :---: |
| **1** | **Introduction and Objectives of the Project** | **3** |
| | 1.1 Project Overview & Background | 3 |
| | 1.2 Purpose of the System | 3 |
| | 1.3 Scope of the Project | 4 |
| | 1.4 Specific Objectives | 4 |
| **2** | **Tools/Platform, Hardware and Software Requirement Specifications** | **5** |
| | 2.1 Hardware Requirements (Development & Client) | 5 |
| | 2.2 Software Specifications (Stack & Dependencies) | 5 |
| | 2.3 Justification of Technology Stack | 6 |
| **3** | **Problem Definition, Requirement Specifications, Project Planning and Scheduling** | **7** |
| | 3.1 Problem Definition (Existing vs. Proposed System) | 7 |
| | 3.2 Detailed Functional Requirements | 7 |
| | 3.3 Technical Specifications & Non-Functional Requirements | 8 |
| | 3.4 Project Planning and Scheduling (WBS, Gantt Chart, PERT Chart) | 9 |
| **4** | **Analysis (Data Models, DFDs, ER Diagram, Class Diagram)** | **11** |
| | 4.1 Data Flow Diagrams (Level 0 Context, Level 1, Level 2) | 11 |
| | 4.2 Entity-Relationship (ER) Diagram with Cardinality | 14 |
| | 4.3 Object-Oriented Class Diagram | 15 |
| **5** | **A Complete Structure of the Project** | **17** |
| | 5.a Number of Modules and Their Description (Student Effort Estimation) | 17 |
| | 5.b Process Logic of Each Module | 18 |
| | 5.c Data Structures as per Project Requirements | 20 |
| | 5.d List of Reports Likely to be Generated | 22 |
| **6** | **Proposed Security Mechanisms at Various Levels** | **23** |
| | 6.1 Authentication and Role-Based Authorization Layer | 23 |
| | 6.2 Application & Web Layer Security (CSRF, Clickjacking) | 23 |
| | 6.3 Input Validation and Data Integrity Layer | 24 |
| | 6.4 Database and Session Security Layer | 24 |
| **7** | **Future Scope and Further Enhancement of the Project** | **25** |
| **8** | **Bibliography and References** | **26** |

\newpage

---

# Chapter 1: Introduction and Objectives of the Project

## 1.1 Project Overview & Background
Higher educational institutions host hundreds of collegiate events annually, spanning cultural festivals, technical hackathons, entrepreneurship summits, and inter-collegiate athletic tournaments. At Uttaranchal University, dynamic campus life requires seamless coordination between student activity councils, academic departments, clubs, faculty coordinators, and the student body.

Traditionally, event notices are dispersed across physical bulletin boards, unstructured messaging channels, and social media flyers. Such decentralization causes significant communication gaps: students miss registration deadlines, event organizers cannot predict venue attendance, popular auditoriums face over-capacity hazards, and coordinators lack real-time visibility into registrations.

The **Campusly: Uttaranchal University Event Management System** is an enterprise-grade, web-based platform designed to centralize and automate the collegiate event lifecycle. Built on Java 25, Spring Boot 3.5.16, Spring Security 6, Spring Data JPA, and Thymeleaf with modern Glassmorphic responsive styling, Campusly provides role-segmented access for administrators and students. It offers real-time event publishing, categorical segmentation (Cultural, Technical, Management, Sports), instantaneous capacity tracking, and asynchronous (AJAX) RSVP seat reservations.

## 1.2 Purpose of the System
The primary purpose of Campusly is to replace disconnected manual workflows with a single, highly accessible digital portal that delivers:
1. **Unified Information Hub:** Aggregates all university events into a single responsive calendar and dashboard with live seat availability indicators.
2. **Instant Ticket/RSVP Allocation:** Empowers students to reserve seats instantly through interactive modal dialogs and asynchronous REST/AJAX endpoints without page reloads.
3. **Automated Capacity Enforcement:** Protects venue limits by enforcing strict seating ceilings, dynamically tracking available vs. booked spots, and marking events "Housefull" when capacity is reached.
4. **Administrative Governance:** Grants authorized event administrators full lifecycle control (Create, Read, Update, Delete) with server-side validation and role-based protection.

## 1.3 Scope of the Project
The scope of Campusly encompasses:
- **User Authentication & Role-Based Access Control (RBAC):** Distinct administrative (`ROLE_ADMIN`) and student (`ROLE_USER`) security contexts with BCrypt password hashing.
- **Categorical Event Classification:** Rigorous partitioning of campus activities into four core festival streams:
  - *Cultural:* Music battles, classical dance showcases, theatrical street plays (*Nukkad Natak*).
  - *Technical:* Agentic AI hackathons, combat robotics (*RoboWars*), full-stack web sprints.
  - *Management:* Business pitch contests (*Shark Tank Campus*), mock HR corporate gauntlets, logical strategy treasure hunts.
  - *Sports:* Floodlight cricket leagues, indoor badminton championships, esports tournaments.
- **Dynamic Seating Management:** Real-time calculation of remaining spots, registration counters, and progress bar fill percentages.
- **Live Search & Client-Side Tab Filtering:** Instantaneous keyword search by title or venue and category tab filtering without full-page reloads.
- **Zero-Downtime Local Persistence:** File-based H2 database engine ensuring persistence across application restarts, with automatic schema updates through Hibernate ORM.

## 1.4 Objectives of the Project
The project was executed to achieve the following specific, measurable technical objectives:
1. **Develop a Robust Backend Architecture:** Utilize Spring Boot 3.5.16 and Java 25 following the Model-View-Controller (MVC) architectural design pattern to ensure clean separation of concerns.
2. **Implement Multi-Tier Security:** Integrate Spring Security 6 to safeguard administrative routes (`/events/new`, `/events/{id}/edit`, `/events/{id}/delete`), enforce CSRF token validation on state-modifying requests, and hash all credentials using BCrypt.
3. **Deliver Asynchronous User Interactivity:** Implement dual RSVP handling—supporting both traditional form submissions and asynchronous AJAX endpoints (`/events/{id}/rsvp`) returning JSON payloads for seamless UI updates.
4. **Ensure Strict Data Integrity:** Enforce declarative Jakarta Bean Validation (`@NotNull`, `@NotBlank`, `@Size`, `@Min`) across entity models and form backing beans.
5. **Craft an Intuitive Glassmorphic User Interface:** Design custom, accessible CSS3 layouts incorporating ambient mesh gradients, badge pills, category-specific themes, and interactive modals.
6. **Provide Automated Bootstrap Seeding:** Integrate an automated `CommandLineRunner` fest seeder that populates multi-category demo events on clean start.

\newpage

---

# Chapter 2: Tools/Platform, Hardware and Software Requirement Specifications

## 2.1 Hardware Requirements
The system is architected as a lightweight, high-throughput web application capable of running efficiently across modest server hardware and standard student devices.

### Table 1: Minimum and Recommended Hardware Specifications
| Hardware Component | Development / Host Server (Minimum) | Production / Server (Recommended) | Client Device (End User) |
| :--- | :--- | :--- | :--- |
| **Processor (CPU)** | Intel Core i3 / AMD Ryzen 3 (2.0 GHz) | Intel Core i5 / AMD Ryzen 5 or higher | Dual Core 1.6 GHz or ARM Mobile |
| **Random Access Memory (RAM)** | 4 GB DDR4 | 8 GB – 16 GB DDR4 | 2 GB (Desktop / Mobile) |
| **Storage / Hard Disk** | 500 MB free storage | 20 GB SSD (NVMe preferred) | Standard browser cache space |
| **Display / Resolution** | 1366 × 768 pixels | 1920 × 1080 pixels | 360 × 640 (Mobile) to 1920 × 1080 |
| **Network Interface** | Standard NIC / Localhost loopback | 100 Mbps / 1 Gbps Ethernet | Wi-Fi / 4G / 5G Mobile Data |

## 2.2 Software Requirement Specifications
Campusly leverages standard, open-source enterprise software technologies conforming to modern industry specifications.

### Table 2: Software Specifications and Environment Setup
| Software Category | Specification / Tool Selected | Version | Purpose in Project |
| :--- | :--- | :--- | :--- |
| **Operating System** | Microsoft Windows 10 / 11, Linux, macOS | 64-bit | Host execution and development environment |
| **Programming Language** | Java Standard Edition (JDK) | 25 LTS | Core server-side object-oriented programming |
| **Application Framework**| Spring Boot | 3.5.16 | Inversion of Control (IoC), Dependency Injection |
| **Web Presentation Engine**| Thymeleaf Template Engine | 3.1.2 | Server-side HTML rendering with dynamic binding |
| **Security Framework** | Spring Security & Thymeleaf Security 6 | 6.3.x | RBAC, authentication, CSRF, BCrypt encryption |
| **Object-Relational Mapping**| Spring Data JPA / Hibernate ORM | 6.5.x | Data access abstraction and repository synthesis |
| **Relational Database** | H2 Database Engine (File-Persistent) | 2.2.x | High-performance embedded ACID relational storage |
| **Validation Engine** | Jakarta Bean Validation (Hibernate Validator) | 3.0.x | Entity and request model constraint validation |
| **Build & Dependency Tool**| Apache Maven | 3.8+ / 3.9+ | Project dependency management, compilation, packaging |
| **Development IDE** | Visual Studio Code / IntelliJ IDEA Community | Latest | Source code editing, debugging, and testing |
| **Client Web Browser** | Google Chrome, Mozilla Firefox, MS Edge | Latest | Cross-browser standards-compliant DOM client |

## 2.3 Justification of Technology Stack
- **Java 25 (LTS):** Delivers long-term stability, strong type safety, enhanced garbage collection algorithms, and modern language features like switch expressions and text blocks.
- **Spring Boot 3.5.16:** Eliminates boilerplate configuration through opinionated auto-configuration, includes an embedded Tomcat 10 HTTP container, and accelerates enterprise deployment.
- **Spring Data JPA:** Drastically reduces boilerplate SQL data access code by dynamically synthesizing repository queries (`findByCategoryIgnoreCaseOrderByEventDateAsc`) from method signatures.
- **Embedded Persistent H2 Database:** Offers zero-configuration deployment without external database server installation. The file-based mode (`jdbc:h2:file:./data/collegeevents;AUTO_SERVER=TRUE`) guarantees transactional ACID persistence across application restarts while supporting multi-process connectivity.
- **Thymeleaf & Spring Security 6:** Allows secure, standards-compliant HTML5 templates with clean attribute decorations (`th:text`, `sec:authorize`), avoiding legacy JSP scriptlets.

\newpage

---

# Chapter 3: Problem Definition, Requirement Specifications, Project Planning and Scheduling

## 3.1 Problem Definition
In traditional college environments, event management suffers from severe procedural deficiencies:
1. **Information Fragmentation:** Announcements are distributed across disparate WhatsApp groups, paper noticeboards, and verbal classroom announcements, resulting in poor student awareness and low turnout.
2. **Absence of Capacity Guardrails:** Venue seating limits are not monitored in real time, causing overcrowding in auditoriums or unexpected vacant seats when unregistered students fail to attend.
3. **Manual Administrative Bottlenecks:** Event coordinators must manually collate physical attendance sheets or Google Forms, resulting in duplicated entries, registration errors, and lack of live verification.
4. **Lack of Category Segmentation:** Students interested in specific technical hackathons or management games must sift through unrelated cultural notices without categorized filtering.

**The Proposed System (Campusly)** resolves these issues by delivering a centralized, web-based event coordination platform that enforces automated capacity checking, category filtering, instant AJAX RSVP, and administrative governance.

## 3.2 Detailed Functional Requirements
The functional requirements are categorized based on user roles:

### Table 3: Functional Requirements Matrix
| Req ID | Module / Feature | Detailed Functional Description | Primary Actor |
| :--- | :--- | :--- | :--- |
| **FR-01** | **Authentication** | Secure login utilizing username and password, validated against BCrypt-hashed credentials. | Student & Admin |
| **FR-02** | **Session Control** | Secure session establishment, persistent session state, and secure invalidation upon logout. | Student & Admin |
| **FR-03** | **Event Listing** | View all scheduled events chronologically sorted with date, venue, capacity, and organizer details. | Student & Admin |
| **FR-04** | **Category Filter** | Filter active events dynamically across Cultural, Technical, Management, and Sports streams. | Student & Admin |
| **FR-05** | **Live Search** | Instantaneous client-side keyword search across event titles, venues, and descriptions. | Student & Admin |
| **FR-06** | **Event Details View** | Access detailed view displaying full agenda, organizer society, and live seating visualizer. | Student & Admin |
| **FR-07** | **Interactive RSVP** | Reserve seats via modal window with asynchronous AJAX dispatch (`/events/{id}/rsvp`) or POST fallback. | Student |
| **FR-08** | **Capacity Guard** | Prevent reservations when `registeredCount >= capacity`; visually mark event as "Housefull". | System / Logic |
| **FR-09** | **Event Creation** | Create new event posts specifying title, category, description, venue, date-time, and capacity. | Administrator |
| **FR-10** | **Event Modification**| Edit existing event records with pre-populated form controls and validation checks. | Administrator |
| **FR-11** | **Event Deletion** | Remove scheduled events with safety confirmation dialogs and cascade cleanup. | Administrator |
| **FR-12** | **Data Seeding** | Automatically initialize standard university fest events when starting on an uninitialized database. | System Startup |

## 3.3 Technical Specifications & Non-Functional Requirements
- **Performance & Latency:** Asynchronous RSVP endpoint responds in under 150 ms under concurrent local requests. Initial page render completes within 1.0 second.
- **Concurrency & Transactional Integrity:** Spring Data JPA `@Transactional` boundary isolates RSVP increments, avoiding race conditions during simultaneous bookings.
- **Cross-Platform Usability:** Fully responsive layout with CSS Flexbox and Grid adapts seamlessly across smartphones (360px+), tablets, and widescreen desktop monitors (1920px).
- **Security:** CSRF token injection on all non-idempotent HTTP methods (`POST`), BCrypt 10-round credential hashing, and X-Frame-Options configured to `SAMEORIGIN`.
- **Maintainability:** Standard three-tier Spring Boot architecture (Controller -> Repository -> Entity) adhering to SOLID design principles.

## 3.4 Project Planning and Scheduling

### 3.4.1 Work Breakdown Structure (WBS)
1. **Phase 1: Inception & Requirements Engineering (Weeks 1–2):** Literature review, problem definition, feasibility study, and SRS document compilation.
2. **Phase 2: Architectural & Database Design (Weeks 3–4):** Entity-relationship modeling, schema definition, DFD creation, and UI wireframing.
3. **Phase 3: Core Backend Development (Weeks 5–7):** Spring Boot setup, Spring Data JPA repositories, Security configuration, and controller endpoints.
4. **Phase 4: Frontend Development & UI Integration (Weeks 8–9):** Thymeleaf templates, custom responsive Glassmorphic CSS, modal dialogs, and AJAX scripts.
5. **Phase 5: Security Hardening & Concurrency Testing (Weeks 10–11):** CSRF verification, input boundary validation, capacity stress testing, and bug fixes.
6. **Phase 6: Project Finalization & Documentation (Week 12):** Project report, synopsis preparation, code comments, and viva voce preparation.

### 3.4.2 Project Gantt Chart
The 12-week development lifecycle is depicted in Table 4.

### Table 4: Project Gantt Chart (12-Week Implementation Schedule)
| Task ID | Task Description | W1 | W2 | W3 | W4 | W5 | W6 | W7 | W8 | W9 | W10 | W11 | W12 |
| :---: | :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **T1** | Requirement Gathering & Feasibility | ■ | ■ | | | | | | | | | | |
| **T2** | System Design (DFD, ERD, Schema) | | | ■ | ■ | | | | | | | | |
| **T3** | JPA Models, Repository & Persistence | | | | | ■ | ■ | | | | | | |
| **T4** | Spring Security & Role Management | | | | | | ■ | ■ | | | | | |
| **T5** | Controller Endpoints & Business Logic| | | | | | | ■ | ■ | | | | |
| **T6** | Thymeleaf UI, CSS Glassmorphism | | | | | | | | ■ | ■ | | | |
| **T7** | AJAX RSVP Engine & Interactive Modals| | | | | | | | | ■ | ■ | | |
| **T8** | Quality Assurance, Testing & Hardening | | | | | | | | | | ■ | ■ | |
| **T9** | Documentation, Synopsis & Deployment | | | | | | | | | | | | ■ |

### 3.4.3 PERT Chart (Program Evaluation and Review Technique)
Critical Path Method (CPM) analysis identifies the sequence of critical project tasks that dictate minimum project duration.

```
       [T1: Req Analysis] (14d)
               │
               ▼
       [T2: System Design] (14d)
               │
               ▼
       [T3: DB & Persistence] (14d)
               │
       ┌───────┴────────────────┐
       ▼                        ▼
[T4: Spring Security] (10d) [T5: Controllers & Logic] (14d)
       │                        │
       └───────┬────────────────┘
               ▼
       [T6: UI & Templates] (14d)
               │
               ▼
       [T7: AJAX RSVP Engine] (7d)
               │
               ▼
       [T8: Testing & Hardening] (10d)
               │
               ▼
       [T9: Final Documentation] (7d)
```
*Critical Path:* **T1 → T2 → T3 → T5 → T6 → T7 → T8 → T9** (Total Duration: 84 Days / 12 Weeks). Tasks on the critical path have zero float.

\newpage

---

# Chapter 4: Analysis (Data Models, DFDs, ER Diagram, Class Diagram)

## 4.1 Data Flow Diagrams (DFDs)
Data Flow Diagrams model how information flows through the system, illustrating external entities, transformation processes, and persistent data stores.

### 4.1.1 Level 0 DFD (Context Diagram)
The Context-Level DFD models Campusly as a single conceptual process interacting with primary external entities (Student and Administrator).

```
   ┌─────────────────────────────────────────────────────────────┐
   │                          STUDENT                            │
   └──────────┬───────────────────────────────────────▲──────────┘
              │ 1. Credentials                        │
              │ 2. Filter / Search Query              │ 1. Auth Status
              │ 3. RSVP Reservation Request           │ 2. Event Calendar / Cards
              │                                       │ 3. RSVP Confirmation / Ticket
              ▼                                       │
      ┌────────────────────────────────────────────────────────┐
      │                                                        │
      │                          0.0                           │
      │        CAMPUSLY: COLLEGE EVENT MANAGEMENT SYSTEM       │
      │                                                        │
      └────────────────────────────────────────────────────────┘
              ▲                                       │
              │ 1. Admin Credentials                  │ 1. Admin Auth Status
              │ 2. Create Event Payload               │ 2. Validation Feedback
              │ 3. Update / Delete Action             │ 3. Live Seating Analytics
              │                                       │
   ┌──────────┴───────────────────────────────────────▼──────────┐
   │                       ADMINISTRATOR                         │
   └─────────────────────────────────────────────────────────────┘
```
**Figure 1: Context Level DFD (Level 0)**

### 4.1.2 Level 1 DFD (Decomposed System Processes)
Level 1 DFD decomposes the system into core operational processes: Authentication (1.0), Event Browsing (2.0), RSVP Booking (3.0), and Event Management (4.0).

```
[External: Student]                      [External: Administrator]
       │                                             │
       ├────────────── Credentials ──────────────────┤
       ▼                                             ▼
┌─────────────────────────┐               ┌─────────────────────────┐
│ 1.0 Authentication &    │<── Verify ───>│ D1: User Credential     │
│ Session Management      │               │     Store (In-Memory)   │
└────────────┬────────────┘               └─────────────────────────┘
             │ Granted Roles
             ├──────────────────────────────────────┐
             ▼                                      ▼
┌─────────────────────────┐               ┌─────────────────────────┐
│ 2.0 Browse, Search &    │               │ 4.0 Manage Events       │
│ Filter Events           │               │ (Create, Edit, Delete)  │
└────────────┬────────────┘               └─────────────┬───────────┘
             │ Read Queries                             │ C/U/D
             ▼                                          ▼
┌───────────────────────────────────────────────────────────────────┐
│                    D2: EVENT_STORE (H2 Database)                  │
└──────────────────────────────────┬────────────────────────────────┘
                                   │ Read / Update Record
                                   ▼
                      ┌─────────────────────────┐
                      │ 3.0 Process RSVP &      │<── Booking Request [Student]
                      │ Seat Allocation         │─── Confirmation / Error ──>
                      └─────────────────────────┘
```
**Figure 2: Level 1 Data Flow Diagram**

### 4.1.3 Level 2 DFD (Sub-Process 3.0: RSVP Seat Allocation)
Level 2 DFD details the transactional logic executed when a student requests an event seat reservation.

```
[Student RSVP Request (ID, Student Name)]
                │
                ▼
        ┌───────────────┐
        │ 3.1 Fetch     │ <────── Read Record by ID
        │ Event Record  │ ──────> D2: EVENT_STORE
        └───────┬───────┘
                │ Event Entity
                ▼
      /───────────────────     < 3.2 Capacity Full?  > ─── [Yes: spotsRemaining <= 0] ───> Return HTTP 400 Bad Request
      \───────────────────/                                       {"success": false, "message": "Housefull"}
                │
                │ [No: spotsRemaining > 0]
                ▼
        ┌───────────────┐
        │ 3.3 Increment │
        │ Count & Save  │ ──────> Update registeredCount in D2: EVENT_STORE
        └───────┬───────┘
                │ Updated Entity
                ▼
        ┌───────────────┐
        │ 3.4 Build     │ ──────> Return HTTP 200 OK JSON Payload
        │ JSON Response │         {"success": true, "registeredCount": N, "spotsRemaining": M}
        └───────────────┘
```
**Figure 3: Level 2 Data Flow Diagram (RSVP Sub-Process)**

## 4.2 Entity-Relationship (ER) Diagram with Cardinality
The database architecture is normalized to maintain integrity across system operations. The conceptual data model depicts the relationships between Users, Roles, Events, and Registrations.

```
       ┌────────────────────────┐                 ┌────────────────────────┐
       │          USER          │                 │          ROLE          │
       ├────────────────────────┤                 ├────────────────────────┤
       │ PK  user_id (INT)      │ M             N │ PK  role_id (INT)      │
       │     username (VARCHAR) ├─────────────────┤     role_name (VARCHAR)│
       │     password (VARCHAR) │   (Has_Role)    └────────────────────────┘
       └───────────┬────────────┘
                   │ 1
                   │
                   │ (Performs)
                   │
                   │ N
       ┌───────────▼────────────┐
       │      REGISTRATION      │
       ├────────────────────────┤
       │ PK  reg_id (BIGINT)    │
       │ FK  event_id (BIGINT)  │
       │ FK  user_id (INT)      │
       │     registered_at (TS) │
       │     attendee_name (VAR)│
       └───────────▲────────────┘
                   │ N
                   │
                   │ (Belongs_To)
                   │
                   │ 1
       ┌───────────┴────────────┐
       │         EVENT          │
       ├────────────────────────┤
       │ PK  id (BIGINT)        │
       │     title (VARCHAR)    │
       │     category (VARCHAR) │
       │     description (TEXT) │
       │     location (VARCHAR) │
       │     event_date (TS)    │
       │     capacity (INT)     │
       │     registered_count   │
       │     organizer (VARCHAR)│
       └────────────────────────┘
```
**Figure 4: Entity-Relationship Diagram with Cardinality**

### Cardinality Specifications:
- **USER to ROLE (M:N):** A user may hold one or multiple security roles (e.g., `ROLE_USER`, `ROLE_ADMIN`), and a role is assigned to multiple users.
- **USER to REGISTRATION (1:N):** One student user can create multiple event registrations over time. Each registration record maps strictly to one user.
- **EVENT to REGISTRATION (1:N):** One campus event can hold multiple student reservations up to its configured seating ceiling (`capacity`). Each reservation belongs to exactly one event.

## 4.3 Object-Oriented Class Diagram
The class diagram documents the structural composition of the system's software architecture, detailing attributes, visibility, return types, and class relationships.

```
┌────────────────────────────────────────────────────────────────────────┐
│                      «entity» Event                                    │
├────────────────────────────────────────────────────────────────────────┤
│ - id: Long                                                             │
│ - title: String                                                        │
│ - category: String                                                     │
│ - description: String                                                  │
│ - location: String                                                     │
│ - eventDate: LocalDateTime                                             │
│ - capacity: Integer                                                    │
│ - registeredCount: Integer                                             │
│ - organizer: String                                                    │
├────────────────────────────────────────────────────────────────────────┤
│ + getId(): Long                                                        │
│ + setId(id: Long): void                                                │
│ + getTitle(): String                                                   │
│ + setTitle(title: String): void                                        │
│ + getSpotsRemaining(): int                                             │
│ + isFull(): boolean                                                    │
│ + getFillPercentage(): int                                             │
│ + getCategorySlug(): String                                            │
│ + getCategoryIcon(): String                                            │
└───────────────────────────────────▲────────────────────────────────────┘
                                    │ manages
┌───────────────────────────────────┴────────────────────────────────────┐
│                    «interface» EventRepository                         │
├────────────────────────────────────────────────────────────────────────┤
│ + findAllByOrderByEventDateAsc(): List<Event>                          │
│ + findByCategoryIgnoreCaseOrderByEventDateAsc(cat: String): List<Event>│
│ + countByCategoryIsNotNull(): long                                     │
└───────────────────────────────────▲────────────────────────────────────┘
                                    │ injects
┌───────────────────────────────────┴────────────────────────────────────┐
│                   «controller» EventController                         │
├────────────────────────────────────────────────────────────────────────┤
│ - eventRepository: EventRepository                                     │
│ - CATEGORIES: List<String>                                             │
├────────────────────────────────────────────────────────────────────────┤
│ + home(): String                                                       │
│ + login(): String                                                      │
│ + dashboard(category: String, model: Model, auth: Auth): String        │
│ + viewEventDetails(id: Long, model: Model, auth: Auth): String         │
│ + rsvpEventAjax(id: Long, reqHeader: String, name: String): Response   │
│ + rsvpEventForm(id: Long, redAttr: RedirectAttributes): String         │
│ + newEvent(model: Model): String                                       │
│ + editEvent(id: Long, model: Model): String                            │
│ + saveEvent(event: Event, result: BindingResult, ...): String          │
│ + deleteEvent(id: Long, redAttr: RedirectAttributes): String           │
│ - isAdmin(authentication: Authentication): boolean                     │
└───────────────────────────────────┬────────────────────────────────────┘
                                    │ secured by
┌───────────────────────────────────┴────────────────────────────────────┐
│                   «configuration» SecurityConfig                       │
├────────────────────────────────────────────────────────────────────────┤
│ + passwordEncoder(): PasswordEncoder                                   │
│ + userDetailsService(encoder: PasswordEncoder, ...): UserDetailsService│
│ + securityFilterChain(http: HttpSecurity): SecurityFilterChain         │
│ - requirePassword(name: String, value: String): void                   │
└────────────────────────────────────────────────────────────────────────┘
```
**Figure 5: Class Diagram of the MVC Architecture**

\newpage

---

# Chapter 5: A Complete Structure of the Project

## 5.a Number of Modules and Their Description (Student Effort Estimation)
Campusly is decomposed into four modular subsystems to optimize maintainability, testability, and cohesion.

### Table 5: Module Breakdown and Student Effort Estimation
| Module ID | Module Title | Primary Architectural Components | Estimated Effort (Hours) | Student Contribution (%) |
| :---: | :--- | :--- | :---: | :---: |
| **M1** | **Authentication & Security Module** | `SecurityConfig.java`, `login.html`, BCrypt filters | 35 Hours | 18% |
| **M2** | **Event Catalog & Dashboard Module** | `EventController.java`, `dashboard.html`, `style.css` | 55 Hours | 28% |
| **M3** | **Interactive RSVP & Seat Engine** | `Event.java`, AJAX handlers, Modal UI scripts | 45 Hours | 23% |
| **M4** | **Admin Lifecycle Management Module** | `EventRepository.java`, `event-form.html`, JPA | 60 Hours | 31% |
| **Total**| **Complete System Architecture** | **Full Application Development Lifecycle** | **195 Hours** | **100%** |

### Module Descriptions:
1. **Module 1: Authentication & Security Module (M1):** Configures Spring Security 6 filter chains, establishes user credential providers (`admin` with `ROLE_ADMIN`, `student` with `ROLE_USER`), manages CSRF token validation, prevents clickjacking via `X-Frame-Options: SAMEORIGIN`, and provides a branded authentication UI.
2. **Module 2: Event Catalog & Discovery Dashboard (M2):** Handles presentation of all active campus events. Features live search, four-stream category tabs (Cultural, Technical, Management, Sports), event card rendering, capacity progress bars, and seat availability pills.
3. **Module 3: Interactive RSVP & Capacity Engine (M3):** Coordinates student reservations. Features dual submission handling: an asynchronous REST endpoint (`/events/{id}/rsvp`) returning JSON for live DOM updates without full page reloads, and a standard form POST fallback (`/events/{id}/register`). Enforces capacity ceilings and manages `isFull` states.
4. **Module 4: Administrative Event Management Module (M4):** Provides authorized staff (`ROLE_ADMIN`) with administrative controls. Handles creation, pre-population for editing, persistence, and deletion of events. Features server-side Jakarta Bean Validation with descriptive inline errors.

## 5.b Process Logic of Each Module

### 1. Process Logic: Authentication & Access Control (M1)
```
BEGIN AuthenticationProcess
    INPUT username, password
    FETCH userRecord FROM UserDetailsService by username
    IF userRecord == NULL THEN
        RETURN LoginError("Invalid username or password")
    END IF
    IF BCrypt.matches(password, userRecord.getPasswordHash()) == TRUE THEN
        CREATE AuthenticatedSession(userRecord.getUsername(), userRecord.getRoles())
        REDIRECT TO "/dashboard"
    ELSE
        RETURN LoginError("Invalid username or password")
    END IF
END
```

### 2. Process Logic: Event Dashboard Filtering & Search (M2)
```
BEGIN DashboardCatalogProcess
    INPUT categoryParameter
    IF categoryParameter IS NOT NULL AND categoryParameter != "All" THEN
        eventsList = EventRepository.findByCategoryIgnoreCaseOrderByEventDateAsc(categoryParameter)
    ELSE
        eventsList = EventRepository.findAllByOrderByEventDateAsc()
    END IF
    POPULATE Model WITH (eventsList, categoryList, userRole, username)
    RENDER "dashboard.html"
END
```

### 3. Process Logic: Asynchronous RSVP Seat Reservation (M3)
```
BEGIN RsvpSeatAllocationProcess
    INPUT eventId, studentName
    FETCH event FROM EventRepository.findById(eventId)
    IF event == NULL THEN
        THROW ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found")
    END IF
    IF (event.getCapacity() - event.getRegisteredCount()) <= 0 THEN
        RETURN HttpResponse(status=400, body={"success": false, "message": "Event is full"})
    END IF
    event.setRegisteredCount(event.getRegisteredCount() + 1)
    EventRepository.save(event)
    spotsRemaining = event.getCapacity() - event.getRegisteredCount()
    fillPercentage = ROUND((event.getRegisteredCount() / event.getCapacity()) * 100)
    RETURN HttpResponse(status=200, body={
        "success": true,
        "message": "RSVP confirmed for " + studentName,
        "registeredCount": event.getRegisteredCount(),
        "spotsRemaining": spotsRemaining,
        "fillPercentage": fillPercentage,
        "isFull": (spotsRemaining <= 0)
    })
END
```

### 4. Process Logic: Admin Event Creation & Modification (M4)
```
BEGIN AdminSaveEventProcess
    INPUT EventObject, BindingResult
    VERIFY CurrentUser.hasRole("ROLE_ADMIN")
    IF BindingResult.hasErrors() == TRUE THEN
        POPULATE Model WITH ErrorMessages
        RENDER "event-form.html"
    END IF
    IF EventObject.getId() == NULL THEN
        EventRepository.save(EventObject)
        SET FlashMessage("Event created successfully!")
    ELSE
        EventRepository.save(EventObject)
        SET FlashMessage("Event details updated successfully!")
    END IF
    REDIRECT TO "/dashboard"
END
```

## 5.c Data Structures as per Project Requirements
Data is organized using Java 25 primitives, domain entities, Java Collections, and relational database tables.

### Table 6: Relational Data Dictionary for `EVENT` Table
| Column Name | SQL Data Type | Nullable | Primary / Foreign Key | Validation Constraints / Description |
| :--- | :--- | :---: | :---: | :--- |
| `id` | `BIGINT` | No | **PK** (Auto Identity) | Unique event identifier generated sequentially |
| `title` | `VARCHAR(120)` | No | None | `@NotBlank`, `@Size(max=120)` Event headline |
| `category` | `VARCHAR(50)` | No | None | `@NotBlank` Categorical bucket (Cultural/Tech/etc.) |
| `description` | `VARCHAR(1500)` | No | None | `@NotBlank`, `@Size(max=1500)` Overview and agenda |
| `location` | `VARCHAR(255)` | No | None | `@NotBlank` Specific auditorium, lab, or ground |
| `event_date` | `TIMESTAMP` | No | None | `@NotNull` Scheduled starting timestamp |
| `capacity` | `INTEGER` | No | None | `@NotNull`, `@Min(1)` Total allowed attendees |
| `registered_count` | `INTEGER` | No | None | Current count of confirmed RSVPs (Default: 0) |
| `organizer` | `VARCHAR(255)` | Yes | None | Responsible student club, society, or department |

### Java Data Structures Employed:
- `java.lang.Long`: Primary key wrapper ensuring null safety prior to entity persistence.
- `java.time.LocalDateTime`: Modern immutable date-time representation without timezone ambiguities.
- `java.util.List<Event>`: Ordered sequential collection storing queries returned by JPA repositories.
- `java.util.Map<String, Object>`: Key-value data structure formatting JSON responses for AJAX endpoints.
- `org.springframework.ui.Model`: Spring MVC data structure passing backend attributes to Thymeleaf templates.

## 5.d List of Reports Likely to be Generated
Campusly includes data structures and query patterns supporting automated reporting for institutional administration:

### Table 7: System Reports and Analytical Summaries
| Report ID | Report Name | Frequency | Target Audience | Key Metrics Included |
| :---: | :--- | :--- | :--- | :--- |
| **RPT-01** | **Comprehensive Event Schedule** | Real-Time / On-Demand | Students & Faculty | Chronological list of events, dates, venues, organizers |
| **RPT-02** | **Category-Wise Distribution Summary**| Weekly / Fest Review | Deans & Head of Dept | Event counts per category (Cultural, Tech, Mgmt, Sports) |
| **RPT-03** | **Venue Capacity Utilization Report** | Post-Registration | Safety & Admin Staff | Total capacity vs. registered count, fill %, Housefull status |
| **RPT-04** | **Student Participation Roster** | Post-Event | Club Coordinators | Complete list of student RSVPs per event for attendance |
| **RPT-05** | **Executive Fest Analytical Briefing** | Conclusion of Fest | Vice Chancellor / Council| Aggregate attendance, popular categories, venue load |

\newpage

---

# Chapter 6: Proposed Security Mechanisms at Various Levels

Modern web applications face a wide range of cyber threats, from credential stuffing and cross-site scripting (XSS) to SQL injection and request forgery. Campusly implements a defense-in-depth security model across four architectural tiers.

```
+-------------------------------------------------------------------------+
| Layer 1: Client & Transport Security (HTTPS, CSRF Tokens, Secure Cookie)|
+-------------------------------------------------------------------------+
                                    |
                                    v
+-------------------------------------------------------------------------+
| Layer 2: Authentication & RBAC (Spring Security 6, BCrypt, Method Auth) |
+-------------------------------------------------------------------------+
                                    |
                                    v
+-------------------------------------------------------------------------+
| Layer 3: Application & Validation (Jakarta Bean Validation, XSS Escaping)|
+-------------------------------------------------------------------------+
                                    |
                                    v
+-------------------------------------------------------------------------+
| Layer 4: Persistence Security (JPA Parameterization, H2 Local Isolation) |
+-------------------------------------------------------------------------+
```
**Figure 6: Multi-Tiered Security Architecture**

## 6.1 Authentication and Role-Based Authorization Layer
- **BCrypt Password Encryption:** All user passwords are encrypted using BCrypt key-derivation hashing with a default work factor (10 rounds). Passwords are never stored or compared in plaintext.
- **Environment Variable Secret Injection:** System passwords (`ADMIN_PASSWORD`, `STUDENT_PASSWORD`) can be injected via external operating system environment variables, preventing credential exposure in source code repositories.
- **Strict Method-Level Security:** Administrative routes are protected using `@PreAuthorize("hasRole('ADMIN')")`. Unauthorized access attempts by students trigger an immediate `HTTP 403 Forbidden` response.

## 6.2 Application & Web Layer Security
- **Cross-Site Request Forgery (CSRF) Mitigation:** Spring Security activates CSRF token validation by default. Non-idempotent HTTP operations (`POST /events/save`, `POST /events/{id}/delete`, `POST /events/{id}/rsvp`) must supply a valid synchronizer token generated per session.
- **Clickjacking Prevention:** Custom security headers configure `frameOptions` to `SAMEORIGIN`, preventing external malicious sites from embedding the university portal inside malicious `<iframe>` wrappers.
- **Contextual Output Escaping (XSS Protection):** The Thymeleaf template engine automatically applies contextual HTML entity encoding to expressions (`th:text`), neutralizing stored and reflected Cross-Site Scripting (XSS) attacks.

## 6.3 Input Validation and Data Integrity Layer
- **Declarative Server-Side Constraint Validation:** Domain models enforce constraints via Jakarta Bean Validation annotations (`@NotBlank`, `@Size`, `@Min`, `@NotNull`). Form submissions with invalid inputs are blocked before database execution, returning contextual field errors.
- **Pre-execution Boundary Checks:** The RSVP endpoint verifies seating limits (`registeredCount < capacity`) before saving, preventing over-booking race conditions.

## 6.4 Database and Session Security Layer
- **SQL Injection Prevention:** Spring Data JPA executes all queries using parameterized `PreparedStatement` interfaces within the Hibernate ORM layer. No raw string concatenation is used, eliminating SQL Injection vulnerabilities.
- **Local Database Isolation:** The H2 database engine operates in local file mode (`./data/collegeevents.mv.db`) with `AUTO_SERVER=TRUE`. The web-based H2 database console is disabled in production environments (`spring.h2.console.enabled=false`), eliminating unauthorized database access risks.

\newpage

---

# Chapter 7: Future Scope and Further Enhancement of the Project

While Campusly provides a fully functioning, robust event management foundation, the system is designed to accommodate ongoing functional and technical enhancements:

1. **Automated QR-Code Electronic Ticket Dispatch:**
   - Integrate the ZXing ("Zebra Crossing") barcode library to generate unique cryptographically signed QR codes for each confirmed RSVP.
   - Deploy a companion mobile web scanner allowing event volunteers to validate student tickets at auditorium doors with immediate status check-in.
2. **Integrated SMS and Email Messaging Gateway:**
   - Integrate Spring Mail (JavaMailSender) and SMS gateways (Twilio / Fast2SMS) to send automated booking confirmations, calendar invites (`.ics`), and deadline reminders directly to registered students.
3. **E-Commerce & Digital Payment Gateway Integration:**
   - Integrate payment aggregators (Razorpay / Stripe) to process paid registrations for premium technical masterclasses and national robotics challenges with real-time webhooks.
4. **Automated Certificate Generation Module:**
   - Integrate Apache PDFBox or iText to auto-generate personalized certificates of participation or merit featuring verified digital signatures and QR verification hashes.
5. **Role Delegation & Multi-Club Governance:**
   - Introduce granular role hierarchies (`ROLE_CLUB_HEAD`, `ROLE_FACULTY_COORDINATOR`, `ROLE_DEAN`) enabling individual student societies to manage their own events while maintaining centralized dean-level approval workflows.
6. **Cloud Containerization & Scalable Database Migration:**
   - Package the application into Docker containers orchestrated via Kubernetes, and transition from embedded H2 to managed enterprise PostgreSQL on AWS RDS or Azure Database.

\newpage

---

# Chapter 8: Bibliography and References

### A. Academic Textbooks and Reference Volumes
1. Walls, Craig. *Spring in Action, Sixth Edition*. Manning Publications, 2022.
2. Martin, Robert C. *Clean Architecture: A Craftsman’s Guide to Software Structure and Design*. Prentice Hall, 2017.
3. Schildt, Herbert. *Java: The Complete Reference, Twelfth Edition*. McGraw-Hill Education, 2021.
4. Pressman, Roger S., and Bruce R. Maxim. *Software Engineering: A Practitioner's Approach, Ninth Edition*. McGraw-Hill, 2020.
5. Silberschatz, Abraham, Henry F. Korth, and S. Sudarshan. *Database System Concepts, Seventh Edition*. McGraw-Hill, 2019.

### B. Official Framework Documentation & Technical Standards
6. VMware Tanzu. *Spring Boot Reference Documentation (v3.5.16)*. Spring Framework Foundation, 2026. https://docs.spring.io/spring-boot/
7. VMware Tanzu. *Spring Security Architecture & Reference Guide (v6.3)*. Spring Framework Foundation, 2024. https://docs.spring.io/spring-security/
8. Thymeleaf Project. *Tutorial: Using Thymeleaf (v3.1)*. Thymeleaf Documentation Team, 2023. https://www.thymeleaf.org/doc/tutorials/3.1/usingthymeleaf.html
9. Hibernate Community. *Hibernate ORM 6.5 User Guide*. Red Hat, Inc., 2024. https://hibernate.org/orm/documentation/
10. H2 Database Engine. *H2 Database Engine Architecture & SQL Reference Guide*. H2 Group, 2024. https://www.h2database.com/html/main.html

### C. Web Resources & Academic Standards
11. University Grants Commission (UGC). *Guidelines for Project Work in Computer Applications*. New Delhi, India.
12. Uttaranchal University. *Academic Project Guidelines for BCA Degree Programs*. Uttaranchal University, Dehradun, 2026.
13. Open Web Application Security Project (OWASP). *OWASP Top 10 Web Application Security Risks*. OWASP Foundation, 2021. https://owasp.org/Top10/
