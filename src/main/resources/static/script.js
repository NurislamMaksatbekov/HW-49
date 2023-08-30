// const resumeForm = document.getElementById('create-resume');
// const addEducationButton = document.getElementById('add-education-button');
// const addExperienceButton = document.getElementById('add-experience-button');
//
// addEducationButton.addEventListener('click', () => {
//     const card = document.createElement('div');
//     const cardHeader = document.createElement('div');
//     card.className = 'card';
//     card.style.marginTop = '20px';
//     cardHeader.innerText = 'Education'
//
//     const education = document.createElement('input');
//     education.type = 'text';
//     education.className = 'form-control';
//     education.id = 'education';
//     education.placeholder = 'Education';
//     education.name = 'education';
//
//     const placeOfStudy = document.createElement('input');
//     placeOfStudy.type = 'text';
//     placeOfStudy.className = 'form-control';
//     placeOfStudy.id = 'placeOfStudy';
//     placeOfStudy.placeholder = 'Place of study';
//     placeOfStudy.name = 'placeOfStudy';
//
//     const studyPeriod = document.createElement('input');
//     studyPeriod.type = 'text';
//     studyPeriod.className = 'form-control';
//     studyPeriod.id = 'studyPeriod';
//     studyPeriod.placeholder = 'Study period';
//     studyPeriod.name = 'studyPeriod';
//
//     card.appendChild(cardHeader)
//     card.appendChild(education)
//     card.appendChild(placeOfStudy)
//     card.appendChild(studyPeriod)
//     resumeForm.appendChild(card);
// })
//
// // function createCardElement(headerText, inputFields) {
// //     const card = document.createElement('div');
// //
// //     card.className = 'card';
// //     card.style.marginTop = '20px';
// //     const cardHeader = document.createElement('div');
// //
// //     cardHeader.className = 'card-header';
// //     cardHeader.innerText = headerText;
// //     const formGroup = document.createElement('div');
// //     for (const field of inputFields) {
// //         const { type, id, placeholder, name } = field;
// //         const input = document.createElement('input');
// //         input.type = type;
// //         input.className = 'form-control';
// //         input.id = id;
// //         input.placeholder = placeholder;
// //         input.name = name;
// //
// //         formGroup.appendChild(input);
// //     }
// //     const deleteButton = document.createElement('i');
// //
// //     deleteButton.className = 'bi bi-x-circle-fill delete-icon';
// //     deleteButton.style.marginLeft = '10px'
// //     cardHeader.appendChild(deleteButton);
// //
// //     card.appendChild(cardHeader);
// //     card.appendChild(formGroup);
// //
// //     resumeForm.appendChild(card);
// // }
// //
// // addExperienceButton.addEventListener('click', () => {
// //     const inputFields = [
// //         { type: 'text', id: 'companyName', placeholder: 'Company Name', name: 'companyName' },
// //         { type: 'text', id: 'responsibilities', placeholder: 'Responsibilities', name: 'responsibilities' },
// //         { type: 'text', id: 'workPeriod', placeholder: 'Work Period', name: 'workPeriod' }
// //     ];
// //     createCardElement('Experience', inputFields);
// // });
// // addEducationButton.addEventListener('click', () => {
// //     const inputFields = [
// //         { type: 'text', id: 'education', placeholder: 'Education', name: 'education' },
// //         { type: 'text', id: 'placeOfStudy', placeholder: 'Place of study', name: 'placeOfStudy' },
// //         { type: 'text', id: 'studyPeriod', placeholder: 'Study Period', name: 'studyPeriod' }
// //     ];
// //     createCardElement('Education', inputFields);
// //     function deleteCard(card) {
// //         card.remove();
// //     }
// //
// //     document.addEventListener('click', (event) => {
// //         const deleteIcon = event.target.closest('.delete-icon');
// //         if (deleteIcon) {
// //             const card = deleteIcon.closest('.card');
// //             if (card) {
// //                 deleteCard(card);
// //             }
// //         }
// //     });
// // });
