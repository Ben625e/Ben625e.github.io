---
layout: default
title: Benjamin Mills ePortfolio
---
# Welcome to My CS-499 ePortfolio
My name is Benjamin Mills and this is my ePortofolio which highlights my time and efforts at SNHU. This ePortfolio will take you through my personal journey in the Computer Science world from start to finish. You can expect to see 3 artifacts later on that highlight what I have learned and how I have improved throughout my time at SNHU.

## Introduction
I am a Computer Science Major at SNHU but that isn't where I started. Beginning in Highschool I found myself interested in technology, computers and programming were a major part of my life. I used computers for many aspects of my life but my biggest deciding factor on pursuing further education on them was my older brother. He was always participating in competitions that I would get to see but one that stuck out to me was a robotics competition where his team built a robot that could navigate an underwater maze. At the time I decided I would follow in his footsteps by getting the same degree in CS which led to me starting at a community college where I enrolled at AACC. I started in 2020 and finished in late 2022 with a Associate in Science in Computer Science. From there I spent my time completing certifications and continuing my learning as finacial setbacks prevented me from immediately starting on my Bachelors. Ultimately I decided on continuing my education where my oldest brother got his degree from, SNHU, in 2024.

Coming into SNHU, I had the basics of programming from AACC and developed IT concepts from my outside certifications. So when I started I felt confident in my ability to code and thought that I would excell with ease. Not that my confidence was shattered but certainly was put to the test throughout my time at SNHU as new concepts I was unfamiliar with would pop up or what I thought I was good at actually had much room for improvements. I felt myself being challenged in my courses and the topics I knew well at a surface level were discussed at a much deeper depth that often made me question if I would do well in once I leave the program. However, with challenge came a need to prove myself which continues to this day as I continue to improve myself and apply my knowledge in relevant ways.

My previous course work found on my Github help highlight my improvement through this course. I purposefully chose an older project for my artifacts to improve so my improvements are much more clearly shown while also choosing a much more recent project to highlight my current skills. This ePortfolio will showcase my skills aquired through my time at SNHU by drawing attention to 3 specific artifacts but they are only a small portion of my talents as it does not include my outside learnings like my certifications or personal projects. Despite that, this ePortfolio will highlight my strengths in programming and specifically target concepts relating to Software Design and Engineering, Algorithms and Data Structures, and Databases.

One professional value that has been taught to me is collaboration. While the artifacts were done independently, my personal projects and the projects they were built on highlight the importance of collaboration in a team environment. The project used for artifact 3 had the website visuals already designed and created which made my job of implementation much faster and streamlined. Similarly, in my personal projects I break up tasks with my group on people's strength while incorporating their feedback and offering my input on their work. A good example is in one of my project for visual entertainment, I had my colleague create some of the more complex visuals since my strength is in the programming side while they are very creative. Throughout the capstone, I had to explain what was done and what will be done which replicate communicating in a professional setting. From the plan phase to the final reflection, the level of communication I performed is similar to real world communication with stakeholders on project status.

In order to create programs that are efficient and scaleable, I have learned and ingrained skills related to data structures and algorithms. These skills help decide what data structure will best fit any given scenario and understand how to improve parts of the programs resource consumption which may be storage, memory, or speed. Creating efficient and scaleable programs isn't enough to achieve value though, that is why I developed strong software engineering skills and soft skills to recognize needs of the project. These software engineering skills create programs that not only reach the goal, but do so in a way that structured and targetted. Soft skills like empathy and targetted questioning help me understand the problem deeper to create a solution that solves their problem rather than just hitting a set of requirements. Throughout this program, my professional certifications, and my personal life, one fact has remained true which is always the need more security. Secure concepts have been drilled into me in every aspect of my teaching and have led me to creating code that always have security at the forefront of its design.

This portfolio's main focus is based around 3 artifacts that improve upon old projects completed in this course. The projects selected will be listed under the respective artifact and will have links to both the original and enhanced version. The first artifact takes a look at an older project completed earlier on in my course which focuses on security automation. This enhancement will focus on the projects goal and what is missing the original projects design that can be added in addition to what can be improved on. This enhancement highlights my critical thinking and secure coding principles as this project focuses on value and understanding project goals from my addition rather than technical skill. The second enhancement focuses on efficiency and communication by increasing the overall speed of the program through data structure changes and coding adjustments. The second enhancement will highlight my skills in reimplementation of existing code and my ability to effectively convey complex topics in ways anyone can understand. The final enhancement will take place on one of my most recent projects and highlight my current technical skill. This enhancement will encorporate soft skills like critical thinking and technical skills like web development or MongoDB. Before enhancements were made on the projects, I first looked over the already existing projects to highlight its current state and explain the specific enhancement in a short informal presentation known as a code review.

## Code Review

<div class="video-container">
  <iframe width="640" height="390" 
    src="https://www.youtube.com/embed/GnDcM9CBogA" 
    title="Benjamin Mills CS-499 Code Review" frameborder="0" 
    allowfullscreen>
  </iframe>
</div>

<style>
.video-container {
  position: relative;
  padding-bottom: 56.25%;
  height: 0;
  overflow: hidden;
  max-width: 100%;
}

.video-container iframe {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
</style>

Above you'll find a link to my code review that was recorded before the enhancements were done to the projects. If the above video does not work you can also find my video [Here](https://www.youtube.com/watch?v=GnDcM9CBogA). A code review is a review of the code which involves checking the code that it meets certain functional requirements, is error free, built to standard, properly documented, and meets style guidelines. It analyzes the code for both problems and areas of improvements, offering a chance for self reflection and is a great tool for collaboration. This was an individual code review which had me analyzing the existing projects and checking them against the guidelines set in the checklist. It also had me explaining the proposed enhancements deeper, explaining where and how it fits into the existing project.

To summarize the existing code review, it starts by taking a look at the CS-320 Project which is used in the first and second artifact. The project is written in Java and inspected in the Eclipse IDE. The project was originally planned to be a part of a mobile application, with security and speed being a top concern. The project consists of 3 many parts which are the Appointment, Contact, and Task portions. Each portion has 4 classes, 1 is a base object to house data, 1 is a controller class which stores an arraylist of the base objects, and 2 test classes for the base object and the controller. Each base class, like the Appointment class, stores a unique ID and relevant data tied to that class. The controller class, like AppointmentService class, handles operations like adding a new Appointment or modifying existing objects. The test classes test for the specific requirements from the original project and each created function using JUnit. From the provided checklist, the project passes the structure portion for the most part although a library function could have been used if the project was to remain in the arraylist structure. The project could have improvements on the documentation, with unnecessary documentation and slightly inconsistant commenting strucutre throughout. The project passes the arithmetic portion although it doesn't apply to the existing code. The project generally passes the loops portion of the checklist although there may be a better way to structure base cases. Finally, the project passes the all the defense criteria in the checklist that applies to this specific project.

The first enhancement was made with the topic of Software Design and Engineering in mind. The code review explains that the planned enhancement will expand on the missing CRUD operations from the project, which is the Read operation. The ability to get stored data is crucial for this mobile application but was a missing part of the original project which was not recognized. The read operation will be incorporated into all 3 portions of the project, inside of the controller classes. This enhancement highlights on the design aspect, as it recognizes crucial overlooked functionality which would make a good portion of the mobile application completely unusable.

The second enhancement was made with the topic of Algorithms and Data Structures in mind. This will also be made in the CS-320 project. This enhancement will change the arraylist structure in the controller classes, into a binary search tree, or BST, structure instead. The code review explains that this will apply to all 3 portions of the project but will still be returning an arraylist from the created read functionality in enhancement 1. The reasoning behind this decision is that the other portion of the mobile application that will be making use of the read function will likely be expecting an arraylist and this will allow those functions to still work properly. The code review defends the choice of a BST by explaining its speed benefits, maintainability, and ease of integration of existing code.


