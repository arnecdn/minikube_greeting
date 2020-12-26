#!/usr/bin/env python3

import requests as req

if __name__ == "__main__":
    with req.get("http://127.0.0.1:55490/greeting",  verify=False) as response:
        print(response.text)

