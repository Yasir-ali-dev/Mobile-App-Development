import 'dart:developer';

import 'package:flutter/material.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Flutter Demo',
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.purple),
        useMaterial3: true,
      ),
      home: simpleScreen(),
    );
  }
}

/*
class simpleScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    String text = "Not a member";
    return Scaffold(
        appBar: AppBar(
          title: const Text("My Sample Title"),
          backgroundColor: Colors.blueAccent,
        ),
        body: Row(
          mainAxisAlignment: MainAxisAlignment.center,
          crossAxisAlignment: CrossAxisAlignment.end,
          children: [
            Text("hi there"),
            Column(
              children: [Text("fdf"), Text("data")],
            )
          ],
        ));
  }
}
*/
class simpleScreen extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    String text = "Not a member";
    return Center(
      child: GestureDetector(
          onTap: () {
            print("object");
          },
          child: Text("hi")),
    );
  }
}
