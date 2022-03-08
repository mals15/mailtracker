# mailtracker

Маслеников Александр;

Тестовое задание на Java EE;

Описание проекта: REST API, который позволяет создавать и отслеживать почтовые отправления. 
                  Имеет три метода: createItem - создание почтового отправления, на вход подается json c полями:
                                    {
                                      "identifier": "identifier123",
                                      "type": "PARCEL",
                                      "recipientIndex" : "432048",
                                      "recipientAddress" : "kirova 6",
                                      "recipientName" : "Alexander"
                                     }
                                     
                                    addItemTracking - добавление пункта отслеживания(
                                                      прибитие в промежуточное почтовое отделение: ARRIVE,
                                                      убытие из почтового отделения: LEAVE,
                                                      получение адресатом: RECEIVE)
                                                      
                                                      на вход подается json с полями:
                                    {
                                      "itemIdentifier": "identifier123",
                                      "postOfficeName": "post_1",
                                      "status" : "RECEIVE"
                                    }
                                    
                                    getItemTrackingHistory - получение статуса и полной истории движения почтового отправления,
                                                             get запрос с идентификатором почтового отправления в ответ на который 
                                                             приходит несколько json следующего вида:
                                    [
                                      {
                                      "id": 1,
                                      "itemIdentifier": "identifier123",
                                      "postOfficeName": "post_1",
                                      "status": "ARRIVE",
                                      "createdDateStatus": "2022-03-08T13:59:56.976123"
                                      },
                                      {
                                      "id": 2,
                                      "itemIdentifier": "identifier123",
                                      "postOfficeName": "post_1",
                                      "status": "LEAVE",
                                      "createdDateStatus": "2022-03-08T14:00:22.209208"
                                      },
                                      {
                                      "id": 3,
                                      "itemIdentifier": "identifier123",
                                      "postOfficeName": "post_1",
                                      "status": "RECEIVE",
                                      "createdDateStatus": "2022-03-08T14:00:31.234352"
                                      }
                                      ]
                                    
