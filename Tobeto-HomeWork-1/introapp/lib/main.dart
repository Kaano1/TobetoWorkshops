import 'package:flutter/material.dart';

void main() {
  runApp(MaterialApp(
    home: Scaffold(
      backgroundColor: const Color.fromARGB(255, 70, 4, 105),
      body: Center(
        child: Column(
            mainAxisAlignment: MainAxisAlignment.center, // Dikeyde merkeze alır
            crossAxisAlignment: CrossAxisAlignment.center,
            children: <Widget>[
              Image.asset(
                "images/kaan.jpg",
                width: 120,
                height: 120,
              ),
              const SizedBox(height: 10),
              const Text(
                "Ahmet Kaan Yumuşakdiken",
                style: TextStyle(
                    color: Colors.white,
                    fontSize: 20.0,
                    fontWeight: FontWeight.bold),
              ),
              const Text(
                "Tobeto - Mobil Geliştirici - 1A",
                style: TextStyle(color: Colors.white),
              ),
              const Text(
                "31.10.2023",
                style: TextStyle(color: Colors.white),
              ),
            ]),
      ),
    ),
  ));
}
