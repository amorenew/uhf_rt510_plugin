/*const String Key_ID = "KEY_ID";
const String Key_EPC = "KEY_EPC";
const String Key_COUNT = "KEY_COUNT";

class TagEPC {
  factory TagEPC.fromJson(Map<String, dynamic> parsedJson) {
    return TagEPC(
        id: parsedJson[Key_ID],
        epc: parsedJson[Key_EPC],
        count: parsedJson[Key_COUNT]);
  }

  final int id;
  final String epc;
  final int count;

  TagEPC({this.id, this.epc, this.count});

  // int getId() {
  //   return this._id;
  // }

  // void setId(int id) {
  //   _id = id;
  // }

  // String getEpc() {
  //   return _epc;
  // }

  // void setEpc(String epc) {
  //   _epc = epc;
  // }

  // int getCount() {
  //   return _count;
  // }

  // void setCount(int count) {
  //   _count = count;
  // }

  String toString() {
    return 'EPC [id=$id, epc=$epc, count=$count]';
  }
}


// To parse this JSON data, do
//
//     final tagEpc = tagEpcFromJson(jsonString);
*/
import 'dart:convert';


class TagEpc {
    final int id;
    final String epc;
    final int count;

    TagEpc({
        this.id,
        this.epc,
        this.count,
    });

    factory TagEpc.fromMap(Map<String, dynamic> json) => TagEpc(
        id: json["KEY_ID"],
        epc: json["KEY_EPC"],
        count: json["KEY_COUNT"],
    );

    Map<String, dynamic> toMap() => {
        "KEY_ID": id,
        "KEY_EPC": epc,
        "KEY_COUNT": count,
    };
    
static List<TagEpc> parseTags(String str) => List<TagEpc>.from(json.decode(str).map((x) => TagEpc.fromMap(x)));

static String tagEpcToJson(List<TagEpc> data) => json.encode(List<dynamic>.from(data.map((x) => x.toMap())));
}
