<?php
header('Content-Type:application/json');
$array = [
    'code'    => 0,
    'msg'     => '',
    'count'   => 6,
    'data'    => [
        [
            'id'            => 1,
            'rule'       => 'admin/add',
            'name'            => '管理员人员添加',
            'cate'          => '管理员管理'],
        [
            'id'            => 1,
            'rule'       => 'admin/add',
            'name'            => '管理员人员添加',
            'cate'          => '管理员管理'],
        [
            'id'            => 1,
            'rule'       => 'admin/add',
            'name'            => '管理员人员添加',
            'cate'          => '管理员管理'],
        [
            'id'            => 1,
            'rule'       => 'admin/add',
            'name'            => '管理员人员添加',
            'cate'          => '管理员管理'],
        [
            'id'            => 1,
            'rule'       => 'admin/add',
            'name'            => '管理员人员添加',
            'cate'          => '管理员管理'],
        [
            'id'            => 1,
            'rule'       => 'admin/add',
            'name'            => '管理员人员添加',
            'cate'          => '管理员管理']
    ]
];

echo json_encode($array);
