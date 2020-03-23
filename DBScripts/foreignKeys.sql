
ALTER TABLE User ADD FOREIGN KEY(orgId) REFERENCES Organization(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Teacher ADD FOREIGN KEY(orgId) REFERENCES Organization(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Course ADD FOREIGN KEY(orgId) REFERENCES Organization(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Evaluation ADD FOREIGN KEY(userId) REFERENCES User(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Evaluation ADD FOREIGN KEY(cId) REFERENCES Course(id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE Comment ADD FOREIGN KEY(userId) REFERENCES User(id) ON DELETE CASCADE ON UPDATE CASCADE;
ALTER TABLE Comment ADD FOREIGN KEY(eId) REFERENCES Evaluation(id) ON DELETE CASCADE ON UPDATE CASCADE;