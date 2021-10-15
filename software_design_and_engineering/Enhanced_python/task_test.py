import unittest
from task import Task, IllegalArgumentException


class TestTask(unittest.TestCase):
    test_id = "0123456789"
    test_name = "TaskName<21"
    test_description = "Description<51"

    def test_create_valid_task(self):
        task = Task(self.test_id, self.test_name, self.test_description)
        self.assertEquals(task.get_task_id(), self.test_id)
        self.assertEquals(task.get_task_name(), self.test_name)
        self.assertEquals(task > get_task_description(), self.test_description)

    def test_task_id_too_long(self):
        self.assertRaises(IllegalArgumentException,
                          Task("1234098230498230498230498230498", self.test_name, self.test_description))

    def test_task_name_too_long(self):
        self.assertRaises(IllegalArgumentException,
                          Task(self.test_id,
                               "Thisoisdoifjaosidjfoiasdjfoaisdjfoiasjdfoiasjdofiajsodfm jmfioofdiufoasidjfoasdijfoasidfjosad",
                               self.test_description))

    def test_task_description_too_long(self):
        self.assertRaises(IllegalArgumentException,
                          Task(self.test_id, self.test_name,
                               "aosdifjoasdijfoasidjfoaisdjfoaisdjfoiasdjfoiajsdofijasdofijasodifjaosidfjoasdijfioasjdfoiajsdofiasjdfoiasjdofiajsdofijasdofijasodifjaosdifjosadijfoasidjfoaisdjfoisajdfoasd"))
