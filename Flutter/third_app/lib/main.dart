import 'package:flutter/material.dart';

void main(){
  runApp(new application());
}

class application extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: "Shimon App",
      home: new Scaffold(
        appBar: new AppBar(title: new Text('Row & Column'),),
        body: new Row(
          children: <Widget>[
            new Text('This'),
            new Text('is'),
            new Text('Row'),
            new Text('This'),
            new Text('This'),
            new Text('This'),
            new Text('This'),
          ],
        ),
      )
    );
  }
}
