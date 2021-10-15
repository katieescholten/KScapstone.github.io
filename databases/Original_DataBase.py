from pymongo import MongoClient
from bson.json_util import dumps


class AnimalShelter(object):

    def __init__(self, username='aacuser', password='aacuser'):
        self.client = MongoClient('mongodb://%s:%s@localhost:37288/AAC' % (username, password))
        self.AAC = self.client['AAC']

    def create(self, data):
        return_value = False
        if data is not None and isinstance(data, dict): #Make sure data is not None and is a dictionary
            print(f'create data: {data}')
            output = self.AAC.animals.insert_one(data)
            print(f'create return: {output}')
            return_value = True
        else:
            print("Nothing to save because data parameter is empty")
        print(f'create return: {return_value}')
        return return_value

    def read(self, query):
        return_value = None
        if query is not None and isinstance(query, dict): #Make sure query is not None and is a dictionary
            print(f'read query: {query}')
            return_value = self.AAC.animals.find(query)
        else:
            print("Query was not a dictionary")
        print(f'read return: {return_value}')
        return return_value
    
    def update(self, data, update_data):
        return_value = False
        if update_data is not None and isinstance(update_data, dict):
            return_value = self.AAC.animals.update_one(data, {'$set': update_data})

        else:
            print("Nothing to update, because data parameter is empty")
        return return_value
    
    def delete(self, delete_id):
        return_value = None
        if update_data is not None and isinstance(delete_id, dict):
            return_cmd_value = self.AAC.animals.delete_many(delete_id)
            return_data_value = dumps(self.read(delete_id))
            print(f'delete_cmd_return: {return_cmd_value}')
            print(f'delete_data_return: {return_data_value}')
        else:
            print("Nothing to delete, because delete_id parameter is empty") 
        return [return_cmd_value, return_data_value]