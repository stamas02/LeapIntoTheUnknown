//
//  ViewController.m
//  LeapIntoTheUnknown
//
//  Created by Nick on 16/02/2015.
//  Copyright (c) 2015 Nick. All rights reserved.
//

#import "ViewController.h"
#import "LeapObjectiveC.h"

@interface ViewController() <LeapDelegate>

@property (nonatomic, strong) LeapController *leapController;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];

    // Do any additional setup after loading the view.
    self.leapController = [[LeapController alloc] init];
    [self.leapController addDelegate:self];
    
}

- (void)setRepresentedObject:(id)representedObject {
    [super setRepresentedObject:representedObject];

    // Update the view, if already loaded.
}

- (void)onFrame:(LeapController *)controller {
    
    // Get the frame
    LeapFrame *frame = [controller frame:0];
    
    // Get the number of hands
    NSUInteger numberHands = [[frame hands] count];
    
    // Format a string
    NSString *handsString;
    switch (numberHands) {
        case 0:
            handsString = @"Look no hands!";
            break;
            
        case 1:
            handsString = @"Look 1 handed!";
            break;
            
        default:
            handsString = [NSString stringWithFormat:@"Look %lu hands!", (unsigned long)numberHands];
            break;
    }
    
    // Drop the string into the text label
    [self.leapLabel setStringValue:handsString];
}

@end
